package com.synapse.data;

import it.unimi.dsi.fastutil.Pair;
import it.unimi.dsi.fastutil.bytes.Byte2LongLinkedOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2LongOpenHashMap;
import it.unimi.dsi.fastutil.objects.ObjectObjectImmutablePair;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class MemoryItemDictionary {
    private AtomicLong sequence;
    private Object2LongOpenHashMap<char[]> dictionary;

    public long encode(char[] token) {
        return dictionary.computeIfAbsent(token, x -> sequence.incrementAndGet());
    }
    public List<Pair<char[], Long>>get() {
        ArrayList<Pair<char[], Long>> list=new ArrayList<>();
        dictionary.object2LongEntrySet().forEach(entry->list.add(new ObjectObjectImmutablePair(entry.getKey(),entry.getLongValue())));
        return list;
    }
}
