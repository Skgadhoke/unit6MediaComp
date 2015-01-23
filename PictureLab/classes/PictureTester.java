/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("birdPuzzle.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
   /** Method to test keepOnlyBlue */
  public static void testkeepOnlyBlue()
  {
    Picture beach = new Picture("birdPuzzle.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test grayScale*/
  public static void testGrayScale()
  {
    Picture beach = new Picture("birdPuzzle.jpg");
    beach.explore();
    beach.grayScale();
    beach.explore();
  }
  
  /** Method to test Sepia */
  public static void testSepia()
  {
      Picture beach = new Picture("birdPuzzle.jpg");
      beach.explore();
      beach.sepia();
      beach.explore();
    
    }
  
  /** Method to test negate*/
  public static void testNegate()
  {
    Picture beach = new Picture("birdPuzzle.jpg");
    beach.explore();
    beach.negate();
    beach.explore();
  }
  
  /** Method to test posterize*/
  public static void testnegate2()
  {
    Picture beach = new Picture("birdPuzzle.jpg");
    beach.explore();
    beach.negate2(2,1,1);
    beach.explore();
  }
  
  /** Method to test underWater*/
  public static void testUnderWater()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.underWater();
    water.explore();
  }
  
   public static void testCreateCollage()
  {
    Picture water = new Picture("water.jpg");
    water.explore();
    water.createCollage();
    water.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("birdPuzzle.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorVerticalRightToLeft */
  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("birdPuzzle.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  /** Method to test mirrorHorizontal */
  public static void testMirrorHorizontal()
  {
    Picture caterpillar = new Picture("birdPuzzle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontal();
    caterpillar.explore();
  }
  
  /** mirrorHorizontalBotToTop */
  public static void testMirrorHorizontalBotToTop()
  {
    Picture caterpillar = new Picture("birdPuzzle.jpg");
    caterpillar.explore();
    caterpillar.mirrorHorizontalBotToTop();
    caterpillar.explore();
      
  }
      
  /** mirrorDiagonal */
  public static void testMirrorDiagonal()
    {
      Picture caterpillar = new Picture("birdPuzzle.jpg");
      caterpillar.explore();
      caterpillar.mirrorDiagonal();
      caterpillar.explore();
   }

   /** mirrorDiagonalRightToLeft */
  public static void testMirrorDiagonalRightToLeft()
    {
      Picture caterpillar = new Picture("birdPuzzle.jpg");
      caterpillar.explore();
      caterpillar.mirrorDiagonalRightToLeft();
      caterpillar.explore();
   }
    /** mirrorPossessed */
  public static void testMirrorPossessed()
    {
      Picture caterpillar = new Picture("birdPuzzle.jpg");
      caterpillar.explore();
      caterpillar.mirrorPossessed();
      caterpillar.explore();
   }
   
    /** Method to crop and copy*/
  public static void testCropAndCopy()
  {
      Picture caterpillar = new Picture("caterpillar.jpg");
      Picture bird = new Picture ("birdPuzzle.jpg");
      caterpillar.explore();
      caterpillar.cropAndCopy(bird, 10, 100, 10, 100, 100, 130);
      caterpillar.explore();
    }

  /** Method to scale a picture by a half*/
  public static void testscaleByHalf()
  {
      Picture caterpillar = new Picture("birdPuzzle.jpg");
      caterpillar.explore();
      caterpillar.mirrorPossessed();
      caterpillar.explore();
    }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("birdPuzzle.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testCopy()
  {
      Picture bird = new Picture("birdPuzzle.jpg");
      bird.explore();
      bird.copy(bird, 100,100);
      bird.explore();
  }
 
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}
