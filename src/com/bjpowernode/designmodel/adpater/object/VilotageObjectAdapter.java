package com.bjpowernode.designmodel.adpater.object;

/**
 * @李永琪
 * @create 2020-10-23 11:05
 */
//duixaing
public class VilotageObjectAdapter implements Vilotage5V{

    private Vilotage220V vilotage220V;

    public VilotageObjectAdapter(Vilotage220V vilotage220V) {
        this.vilotage220V = vilotage220V;
    }


    @Override
    public int output5V() {
        int srcV = vilotage220V.output220V();
        int destV = srcV / 44;
        return destV;
    }
}
