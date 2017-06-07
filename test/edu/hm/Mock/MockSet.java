package edu.hm.Mock;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by lapi on 07/06/2017.
 */
public class MockSet extends HashSet {
    private boolean c;
    public MockSet(boolean contain){
        c = contain;
    }
    @Override public boolean contains(Object o){
        return c;
    }
}
