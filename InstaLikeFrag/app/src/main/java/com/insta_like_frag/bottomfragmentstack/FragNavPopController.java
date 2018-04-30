package com.insta_like_frag.bottomfragmentstack;

public interface FragNavPopController {
    int tryPopFragments(int popDepth, FragNavTransactionOptions transactionOptions) throws UnsupportedOperationException;
}
