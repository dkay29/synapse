package com.synapse.data;

public class BrainCell {
    static Object sync=new Object();
    private BrainCell[] after;
    private BrainCell[] before;
    private BrainCell[] associated;
    private long encodedMemories[];

    public void addAfter(BrainCell[] brainCellList) {
        connect(after,brainCellList);
    }
    public void addAfter(BrainCell singleBrainCell) {
        BrainCell[] list = { singleBrainCell  };
        connect(after,list);
    }
    public void addBefore(BrainCell[] brainCellList) {
        connect(before,brainCellList);
    }
    public void addBefore(BrainCell singleBrainCell) {
        BrainCell[] list = { singleBrainCell  };
        connect(before,list);
    }
    public void addAssociated(BrainCell[] brainCellList) {
        connect(associated,brainCellList);
    }
    public void addAssociated(BrainCell singleBrainCell) {
        BrainCell[] list = { singleBrainCell  };
        connect(associated,list);
    }

    private void connect(BrainCell[] existing, BrainCell additions[]) {
        synchronized (sync) {
            int newLength=(existing==null?0:existing.length) +(additions==null?0:additions.length);
            BrainCell[] newConnections= new BrainCell[newLength];
            int i=0;
            if (existing!=null) {
                System.arraycopy(newConnections,0,existing,0,i=existing.length);
            }
            if (additions!=null) {
                System.arraycopy(newConnections,i,additions,0,additions.length);
            }
        }
    }
}
