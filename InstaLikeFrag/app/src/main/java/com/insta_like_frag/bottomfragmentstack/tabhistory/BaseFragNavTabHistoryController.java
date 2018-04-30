package com.insta_like_frag.bottomfragmentstack.tabhistory;


import com.insta_like_frag.bottomfragmentstack.FragNavPopController;

abstract class BaseFragNavTabHistoryController implements FragNavTabHistoryController {
    FragNavPopController fragNavPopController;

    BaseFragNavTabHistoryController(FragNavPopController fragNavPopController) {
        this.fragNavPopController = fragNavPopController;
    }
}
