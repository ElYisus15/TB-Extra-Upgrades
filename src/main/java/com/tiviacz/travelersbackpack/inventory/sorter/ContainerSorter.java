package com.tiviacz.travelersbackpack.inventory.sorter;

import com.mojang.datafixers.util.Pair;
import com.tiviacz.travelersbackpack.inventory.BackpackWrapper;
import com.tiviacz.travelersbackpack.util.ItemStackUtils;
import com.tiviacz.travelersbackpack.util.Reference;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.IItemHandlerModifiable;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.InvWrapper;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

public class ContainerSorter {
    public static final int SORT_BACKPACK = 0;
    public static final int QUICK_STACK = 1;
    public static final int TRANSFER_TO_BACKPACK = 2;
    public static final int TRANSFER_TO_PLAYER = 3;

    public static void selectSort(BackpackWrapper backpackWrapper, Player player, int button, boolean shiftPressed) {
        if(button == SORT_BACKPACK) {
            sortBackpack(backpackWrapper, player, SortType.Type.CATEGORY, shiftPressed);
        } else if(button == QUICK_STACK) {
            quickStackToBackpackNoSort(backpackWrapper, player, shiftPressed);
        } else if(button == TRANSFER_TO_BACKPACK) {
            transferToBackpackNoSort(backpackWrapper, player, shiftPressed);
        } else if(button == TRANSFER_TO_PLAYER) {
            transferToPlayer(backpackWrapper, player);
        }
    }

    public static void sortBackpack(BackpackWrapper backpackWrapper, Player player, SortType.Type type, boolean shiftPressed) {
        List<ItemStack> stacks = new ArrayList<>();
        CustomWrapper storage = new CustomWrapper(backpackWrapper, backpackWrapper.getStorage()); //backpackWrapper.getStorage();
        for(int i = 0; i < storage.getSlots(); i++) {
            addStackWithMerge(stacks, backpackWrapper.getUnsortableSlots().contains(i) ? ItemStack.EMPTY : storage.getStackInSlot(i)); //container.getSlotManager().isSlot(SlotManagerOld.UNSORTABLE, i) ? ItemStack.EMPTY : wrapper.getStackInSlot(i));
        }
        if(!stacks.isEmpty()) {
            stacks.sort(Comparator.comparing(stack -> SortType.getStringForSort(stack, type)));
        }
        if(stacks.isEmpty()) return;
        int j = 0;
        for(int i = 0; i < storage.getSlots(); i++) {
            if(backpackWrapper.getUnsortableSlots().contains(i)) continue;
            //if(container.getSlotManager().isSlot(SlotManagerOld.UNSORTABLE, i)) continue;
            storage.setStackInSlot(i, j < stacks.size() ? stacks.get(j) : ItemStack.EMPTY);
            j++;
        }
    }

    public static void quickStackToBackpackNoSort(BackpackWrapper backpackWrapper, Player player, boolean shiftPressed) {
        IItemHandler playerStacks = new InvWrapper(player.getInventory());
        for(int i = shiftPressed ? 0 : 9; i < 36; ++i) {
            ItemStack playerStack = playerStacks.getStackInSlot(i);
            if(playerStack.isEmpty() || (backpackWrapper.getScreenID() == Reference.ITEM_SCREEN_ID && i == (backpackWrapper.getBackpackSlotIndex() == -1 ? player.getInventory().selected : backpackWrapper.getBackpackSlotIndex())))
                continue;
            CustomWrapper storage = new CustomWrapper(backpackWrapper, backpackWrapper.getStorage());
            boolean hasExistingStack = IntStream.range(0, storage.getSlots()).mapToObj(storage::getStackInSlot).filter(existing -> !existing.isEmpty()).anyMatch(existing -> existing.getItem() == playerStack.getItem());
            if(!hasExistingStack) continue;
            ItemStack ext = playerStacks.extractItem(i, Integer.MAX_VALUE, false);
            for(int j = 0; j < storage.getSlots(); ++j) {
                ext = storage.insertItem(j, ext, false);
                if(ext.isEmpty()) break;
            }
            if(!ext.isEmpty()) {
                playerStacks.insertItem(i, ext, false);
            }
        }
    }

    public static void transferToBackpackNoSort(BackpackWrapper backpackWrapper, Player player, boolean shiftPressed) {
        IItemHandler playerStacks = new InvWrapper(player.getInventory());
        //Run for Memory Slots
        if(!backpackWrapper.getMemorySlots().isEmpty()) {
            for(Pair<Integer, Pair<ItemStack, Boolean>> pair : backpackWrapper.getMemorySlots()) {
                for(int i = shiftPressed ? 0 : 9; i < 36; ++i) {
                    ItemStack playerStack = playerStacks.getStackInSlot(i);
                    if(playerStack.isEmpty() || (backpackWrapper.getScreenID() == Reference.ITEM_SCREEN_ID && i == (backpackWrapper.getBackpackSlotIndex() == -1 ? player.getInventory().selected : backpackWrapper.getBackpackSlotIndex())))
                        continue;
                    CustomWrapper wrapper = new CustomWrapper(backpackWrapper, backpackWrapper.getStorage());
                    ItemStack extSimulate = playerStacks.extractItem(i, Integer.MAX_VALUE, true);
                    ItemStack ext = ItemStack.EMPTY; //playerStacks.extractItem(i, Integer.MAX_VALUE, false);
                    if(pair.getSecond().getSecond() ? ItemStackUtils.isSameItemSameTags(pair.getSecond().getFirst(), extSimulate) : ItemStack.isSameItem(pair.getSecond().getFirst(), extSimulate)) {
                        ext = playerStacks.extractItem(i, Integer.MAX_VALUE, false);
                        ext = wrapper.insertItem(pair.getFirst(), ext, false);
                        if(ext.isEmpty()) continue;
                    }
                    if(!ext.isEmpty()) {
                        playerStacks.insertItem(i, ext, false);
                    }
                }
            }
        }

        //Run for Normal Slots
        for(int i = shiftPressed ? 0 : 9; i < 36; ++i) {
            ItemStack playerStack = playerStacks.getStackInSlot(i);
            if(playerStack.isEmpty() || (backpackWrapper.getScreenID() == Reference.ITEM_SCREEN_ID && i == (backpackWrapper.getBackpackSlotIndex() == -1 ? player.getInventory().selected : backpackWrapper.getBackpackSlotIndex())))
                continue;
            CustomWrapper wrapper = new CustomWrapper(backpackWrapper, backpackWrapper.getStorage());
            ItemStack ext = playerStacks.extractItem(i, Integer.MAX_VALUE, false);
            for(int j = 0; j < wrapper.getSlots(); ++j) {
                ext = wrapper.insertItem(j, ext, false);
                if(ext.isEmpty()) break;
            }
            if(!ext.isEmpty()) {
                playerStacks.insertItem(i, ext, false);
            }
        }
    }

    public static void transferToPlayer(BackpackWrapper backpackWrapper, Player player) {
        IItemHandler playerStacks = new InvWrapper(player.getInventory());
        CustomWrapper wrapper = new CustomWrapper(backpackWrapper, backpackWrapper.getStorage());
        for(int i = 0; i < wrapper.getSlots(); ++i) {
            ItemStack stack = wrapper.getStackInSlot(i);
            if(stack.isEmpty()) continue;
            ItemStack ext = wrapper.extractItem(i, Integer.MAX_VALUE, false);
            for(int j = 9; j < 36; ++j) {
                ext = playerStacks.insertItem(j, ext, false);
                if(ext.isEmpty()) break;
            }
            if(!ext.isEmpty()) {
                wrapper.isTransferToPlayer = true;
                wrapper.insertItem(i, ext, false);
                wrapper.isTransferToPlayer = false;
            }
        }
    }

    private static void addStackWithMerge(List<ItemStack> stacks, ItemStack newStack) {
        if(newStack.isEmpty()) return;
        if(newStack.isStackable() && newStack.getCount() != newStack.getMaxStackSize()) {
            for(int j = stacks.size() - 1; j >= 0; j--) {
                ItemStack oldStack = stacks.get(j);
                if(canMergeItems(newStack, oldStack)) {
                    combineStacks(newStack, oldStack);
                    if(oldStack.isEmpty() || oldStack.getCount() == 0) {
                        stacks.remove(j);
                    }
                }
            }
        }
        stacks.add(newStack);
    }

    private static void combineStacks(ItemStack stack, ItemStack stack2) {
        if(stack.getMaxStackSize() >= stack.getCount() + stack2.getCount()) {
            stack.grow(stack2.getCount());
            stack2.setCount(0);
        }
        int maxInsertAmount = Math.min(stack.getMaxStackSize() - stack.getCount(), stack2.getCount());
        stack.grow(maxInsertAmount);
        stack2.shrink(maxInsertAmount);
    }

    private static boolean canMergeItems(ItemStack stack1, ItemStack stack2) {
        if(!stack1.isStackable() || !stack2.isStackable()) {
            return false;
        }
        if(stack1.getCount() == stack2.getMaxStackSize() || stack2.getCount() == stack2.getMaxStackSize()) {
            return false;
        }
        if(stack1.getItem() != stack2.getItem()) {
            return false;
        }
        if(stack1.getDamageValue() != stack2.getDamageValue()) {
            return false;
        }
        return ItemStack.isSameItemSameComponents(stack1, stack2);
    }

    public static class CustomWrapper implements IItemHandlerModifiable {
        public final BackpackWrapper wrapper;
        public final ItemStackHandler parent;
        public boolean isTransferToPlayer;

        public CustomWrapper(BackpackWrapper wrapper, ItemStackHandler parent) {
            this(wrapper, parent, false);
        }

        public CustomWrapper(BackpackWrapper wrapper, ItemStackHandler parent, boolean isTransferToPlayer) {
            this.wrapper = wrapper;
            this.parent = parent;
            this.isTransferToPlayer = isTransferToPlayer;
        }

        @Override
        public void setStackInSlot(int slot, @NotNull ItemStack stack) {
            parent.setStackInSlot(slot, stack);
        }

        @Override
        public int getSlots() {
            return parent.getSlots();
        }

        @Override
        public @NotNull ItemStack getStackInSlot(int slot) {
            return parent.getStackInSlot(slot);
        }

        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            if(wrapper.getMemorizedSlot(slot).isPresent()) {
                return wrapper.getMemorySlots().stream().noneMatch(pair -> {
                    if(pair.getSecond().getSecond()) {
                        return pair.getFirst() == slot && ItemStackUtils.isSameItemSameTags(pair.getSecond().getFirst(), stack);
                    } else {
                        return pair.getFirst() == slot && ItemStack.isSameItem(pair.getSecond().getFirst(), stack);
                    }
                }) ? stack : parent.insertItem(slot, stack, simulate);
            }
            return wrapper.getUnsortableSlots().contains(slot) ? stack : parent.insertItem(slot, stack, simulate);
        }

        @Override
        public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
            return wrapper.getUnsortableSlots().contains(slot) ? ItemStack.EMPTY : parent.extractItem(slot, amount, simulate);
        }

        @Override
        public int getSlotLimit(int slot) {
            return parent.getSlotLimit(slot);
        }

        @Override
        public boolean isItemValid(int slot, @NotNull ItemStack stack) {
            return parent.isItemValid(slot, stack);
        }
    }
}