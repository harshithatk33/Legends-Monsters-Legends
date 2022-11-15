/**
 * This is a Enum Class to have different spots available on the Board
 * Author : Harshitha T K
 * Date   : Nov 1
 */
public enum BlockTypes {
    MARKETPLACE,
    INACCESSIBLE,
    COMMON;

  public static String getSymbols(BlockTypes customType){
      if (customType == BlockTypes.MARKETPLACE) {
          return "M";
      } else if (customType == BlockTypes.INACCESSIBLE) {
          return "&";
      } else {
          return " ";
      }
  }

  public static String getColors(BlockTypes customColors){

      if (customColors == BlockTypes.MARKETPLACE) {
          return AsciiColors.YELLOW;
      } else if (customColors == BlockTypes.INACCESSIBLE) {
          return AsciiColors.RED;
      } else {
          return AsciiColors.WHITE;
      }
  }
}
