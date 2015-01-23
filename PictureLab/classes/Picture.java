import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
      ///////////////////// constructors //////////////////////////////////
      
      /**
       * Constructor that takes no arguments 
       */
      public Picture ()
      {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
      }
      
      /**
       * Constructor that takes a file name and creates the picture 
       * @param fileName the name of the file to create the picture from
       */
      public Picture(String fileName)
      {
        // let the parent class handle this fileName
        super(fileName);
      }
      
      /**
       * Constructor that takes the width and height
       * @param height the height of the desired picture
       * @param width the width of the desired picture
       */
      public Picture(int height, int width)
      {
        // let the parent class handle this width and height
        super(width,height);
      }
      
      /**
       * Constructor that takes a picture and creates a 
       * copy of that picture
       * @param copyPicture the picture to copy
       */
      public Picture(Picture copyPicture)
      {
        // let the parent class do the copy
        super(copyPicture);
      }
      
      /**
       * Constructor that takes a buffered image
       * @param image the buffered image to use
       */
      public Picture(BufferedImage image)
      {
        super(image);
      }
      
      ////////////////////// methods ///////////////////////////////////////
      
      /**
       * Method to return a string with information about this picture.
       * @return a string with information about the picture such as fileName,
       * height and width.
       */
      public String toString()
      {
        String output = "Picture, filename " + getFileName() + 
          " height " + getHeight() 
          + " width " + getWidth();
        return output;
        
      }
      
      /** Method to set the blue to 0 */
      public void zeroBlue()
      {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels)
        {
          for (Pixel pixelObj : rowArray)
          {
            pixelObj.setBlue(0);
          }
        }
      }
      
      /** Keep only blue method */
      public void keepOnlyBlue()
        {
         Pixel[][] pixels = this.getPixels2D();
         for (Pixel[] rowArray : pixels)
         {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(0);
                pixelObj.setRed(0);
            }
         }
        }
        
      /** Negate all pixels in a picture */
      public void negate()
      {
         Pixel[][] pixels = this.getPixels2D();
         
          for (Pixel[] rowArray : pixels)
         {
            for (Pixel pixelObj : rowArray)
            {
                pixelObj.setGreen(255-pixelObj.getGreen());
                pixelObj.setBlue(255-pixelObj.getBlue());
                pixelObj.setRed(255-pixelObj.getRed());
            }
         }
        
      }
      
      public void negate2(int val1, int val2, int val3)
      {
          Pixel[][] pixels = this.getPixels2D();
         
          for (Pixel[] rowArray : pixels)
         {
            for (Pixel pixelObj : rowArray)
            {
                if(val1!=0 && val2!=0 && val3!=0)
                {
                    pixelObj.setGreen((255-pixelObj.getGreen())/val1);
                    pixelObj.setBlue((255-pixelObj.getBlue())/val2);
                    pixelObj.setRed((255-pixelObj.getRed())/val3);
                }
                else
                {
                    pixelObj.setGreen((255-pixelObj.getGreen())/2);
                    pixelObj.setBlue(255-pixelObj.getBlue());
                    pixelObj.setRed(255-pixelObj.getRed());
                }
                
            }
         }
        }
      
      /** grayScale method */
      public void grayScale()
      {
          Pixel[][] pixels = this.getPixels2D();
         int currGreen;
         int currBlue;
         int currRed;
         int avg;
          for (Pixel[] rowArray : pixels)
         {
            for (Pixel pixelObj : rowArray)
            {
                currGreen=pixelObj.getGreen();
                currBlue=pixelObj.getBlue();
                currRed=pixelObj.getRed();
                avg = (currGreen + currBlue + currRed)/3;
                
                pixelObj.setGreen(avg);
                pixelObj.setBlue(avg);
                pixelObj.setRed(avg);
                
            }
         }
      }
      /** sepia */
        
      public void sepia(int val1, int val2, int val3)
        {
            Pixel[][] pixels = this.getPixels2D();
         int currGreen;
         int currBlue;
         int currRed;
         int avg;
          for (Pixel[] rowArray : pixels)
         {
            for (Pixel pixelObj : rowArray)
            {
                currGreen=pixelObj.getGreen();
                currBlue=pixelObj.getBlue();
                currRed=pixelObj.getRed();
                avg = (currGreen + currBlue + currRed)/3;
                
                pixelObj.setGreen(avg*val1);
                pixelObj.setBlue(avg*val2);
                pixelObj.setRed(avg*3);
                
            }
         }
        }
      
      
      /** fixUnderwater method */
      public void underWater()
      {
         Pixel[][] pixels = this.getPixels2D();
         int currGreen;
         int currBlue;
         int currRed;
         for (Pixel[] rowArray : pixels)
         {
            for (Pixel pixelObj : rowArray)
            {
                currGreen=pixelObj.getGreen();
                currBlue=pixelObj.getBlue();
                currRed=pixelObj.getRed();
                
                pixelObj.setRed(currRed*3);
                
            }
         }
        }
      
      /** Method that mirrors the picture around a 
        * vertical mirror in the center of the picture
        * from left to right */
      public void mirrorVertical()
      {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
          for (int col = 0; col < width / 2; col++)
          {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
      /** Mirror vertical from right to left*/
      public void mirrorVerticalRightToLeft()
      {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++)
        {
          for (int col = 0; col < width / 2; col++)
          {
            leftPixel = pixels[row][width - 1 - col];
            rightPixel = pixels[row][col];
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
      /** Mirror horizontally */
      public void mirrorHorizontal()
      {
          Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
         for (int row = 0; row < height/2; row++)
        {
          for (int col = 0; col < width; col++)
          {
            leftPixel = pixels[row][col];
            rightPixel = pixels[height - 1 - row][col];
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
      /**mirrorHorizontalBotToTop */
      public void mirrorHorizontalBotToTop()
      {
          Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
         for (int row = 0; row < height/2; row++)
        {
          for (int col = 0; col < width; col++)
          {
            leftPixel = pixels[height - 1 - row][col];
            rightPixel = pixels[row][col];
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
      /** mirrorPossessed */ 
      public void mirrorPossessed()
      {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
         for (int row = 0; row < height; row++)
        {
          for (int col = 0; col < width; col++)
          {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][width - 1 - col];
            if(row <= col)
            {
                rightPixel = pixels[height - 1 - row][col];
            }
            
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
      /** mirrorDiagonal */ 
      public void mirrorDiagonal()
      {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        int height = pixels.length;
         for (int row = 0; row < height; row++)
        {
          for (int col = 0; col < width; col++)
          {
            leftPixel = pixels[row][col];
            if(row >= col)
            {
                rightPixel = pixels[col][row];
            }
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
       /** mirrorDiagonalRightToLeft */ 
      public void mirrorDiagonalRightToLeft()
      {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels.length;
        int height = pixels[0].length;
         for (int row = 0; row < width; row++)
        {
          for (int col = 0; col < height; col++)
          {
            leftPixel = pixels[row][col];
            if(row < col && col < 150)
            {
                rightPixel = pixels[col][row];
            }
            else
            {
                rightPixel = pixels[row][col];
            }
            rightPixel.setColor(leftPixel.getColor());
          }
        } 
      }
      
      /** Mirror just part of a picture of a temple */
      public void mirrorTemple()
      {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();
        
        // loop through the rows
        for (int row = 27; row < 97; row++)
        {
          // loop from 13 to just before the mirror point
          for (int col = 13; col < mirrorPoint; col++)
          {
            
            leftPixel = pixels[row][col];      
            rightPixel = pixels[row]                       
                             [mirrorPoint - col + mirrorPoint];
            rightPixel.setColor(leftPixel.getColor());
          }
        }
      }
      public Picture crop( int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol)
      {
        Picture croppedPicture = new Picture(endSourceRow-startSourceRow,endSourceCol-startSourceCol);
          Pixel[][] desPixel = croppedPicture.getPixels2D();
        Pixel[][] sourcPixel=this.getPixels2D();
        Pixel dPixels = null;
        Pixel sPixels = null;
        
        
        for (int row=startSourceRow, drow = 0; row<endSourceRow; row++, drow++)
        {
            for(int col=startSourceCol, dcol=0; col<endSourceCol; col++, dcol++)
                {  
                  sPixels = sourcPixel[row][col];
                  dPixels = desPixel[drow][dcol];
                  dPixels.setColor(sPixels.getColor());
                  //this.copy(sourcePicture,startSourceRow, startSourceCol);
                    
            }
        }
        return croppedPicture;
      }
        
      public void cropAndCopy( Picture sourcePicture, int startSourceRow, int endSourceRow, int startSourceCol, int endSourceCol,
             int startDestRow, int startDestCol )
       {
          Picture croppedPic = sourcePicture.crop(startSourceRow,endSourceRow, startSourceCol, endSourceCol);
          copy(croppedPic,startDestRow,startDestCol);
       }
      
        
      /** copy from the passed fromPic to the
        * specified startRow and startCol in the
        * current picture
        * @param fromPic the picture to copy from
        * @param startRow the start row to copy to
        * @param startCol the start col to copy to
        */
      public void copy(Picture fromPic, 
                     int startRow, int startCol)
      {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow; 
             fromRow < fromPixels.length &&
             toRow < toPixels.length; 
             fromRow++, toRow++)
        {
          for (int fromCol = 0, toCol = startCol; 
               fromCol < fromPixels[0].length &&
               toCol < toPixels[0].length;  
               fromCol++, toCol++)
          {
            fromPixel = fromPixels[fromRow][fromCol];
            toPixel = toPixels[toRow][toCol];
            toPixel.setColor(fromPixel.getColor());
          }
        }   
      }
      Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
      /** Method to create a collage of several pictures */
      public void createCollage()
      {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1,0,0);
        this.copy(flower2,100,0);
        this.copy(flower1,200,0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue,300,0);
        this.copy(flower1,400,0);
        this.copy(flower2,500,0);
        this.mirrorVertical();
        this.write("collage.jpg");
      }
      
      
      /** Method to show large changes in color 
        * @param edgeDist the distance for finding edges
        */
      public void edgeDetection(int edgeDist)
      {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++)
        {
          for (int col = 0; 
               col < pixels[0].length-1; col++)
          {
            leftPixel = pixels[row][col];
            rightPixel = pixels[row][col+1];
            rightColor = rightPixel.getColor();
            if (leftPixel.colorDistance(rightColor) > 
                edgeDist)
              leftPixel.setColor(Color.BLACK);
            else
              leftPixel.setColor(Color.WHITE);
          }
        }
      }
      
      
      /* Main method for testing - each class in Java can have a main 
       * method 
       */
      public static void main(String[] args) 
      {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
      }
  
} // this } is the end of class Picture, put all new methods before this
