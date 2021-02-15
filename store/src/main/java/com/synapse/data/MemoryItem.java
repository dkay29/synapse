package com.synapse.data;

import java.util.Arrays;

/** An atomic item of memory
 */
public class MemoryItem {
    char[] token;
    long code;

    public MemoryItem(char[] token, long code) {
        this.token = token;
        this.code = code;
    }
    public MemoryItem(String token, long code) {
        this(token.toCharArray(),code);
    }
    public char[] getToken() {
        return token;
    }

    public long getCode() {
        return code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MemoryItem)) return false;
        MemoryItem that = (MemoryItem) o;
        return Arrays.equals(token, that.token);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(token);
    }
}
