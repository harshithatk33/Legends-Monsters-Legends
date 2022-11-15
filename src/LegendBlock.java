/**
 The legend Block class which is inherited by the SingleBlock Class, inheriting properties in that class and to add specific properities to this Legends game
 Author : Harshitha T K
 Date   : Nov 1
 */

public class LegendBlock extends SingleBlocks {

    private BlockTypes blockType;
    public BlockTypes getBlockType() {
        return blockType;
    }

    public void setBlockType(BlockTypes blockType) {
        this.blockType = blockType;
    }

    LegendBlock(Integer positionOfObject, Integer dimensionA, Integer dimensionB ){
        super(positionOfObject,dimensionA,dimensionB);
        this.setBlockType(BlockTypes.COMMON);
    }


}
