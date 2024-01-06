package com.art.apifeature;

import com.art.apifeature._common.helpers.CheckBasicToken;

public class TestTest {
    public static void main(String[] args) {
        CheckBasicToken.decodeBasicToken("YXJ0OjEyMw==", "art:123");

        System.out.println();
    }
}
