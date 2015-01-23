public class collage
{
    public static void main(String[] args)
    {
        Picture bird = new Picture("birdPuzzle.jpg");
        bird.explore();
        Picture bird2 = new Picture("birdPuzzle.jpg");
        bird2.negate2(2,1,1);
        bird2.mirrorHorizontal();
        bird.cropAndCopy(bird2, 10, 200, 10, 100, 10, 30);
        
        //Negate Mirror Diagonal
        bird2.negate();
        Picture bird4 = new Picture(bird2);
        bird4.mirrorVertical();
        bird4.mirrorDiagonal();
        bird.cropAndCopy(bird4, 20, 130, 250, 370, 35,280);
        
        //Sepial 
        bird2.sepia(1,2,1);
        bird2.mirrorDiagonal();
        bird4 = new Picture(bird2);
        bird.cropAndCopy(bird4, 95,300, 180, 340, 170, 218);
        
        //Gray Scale
        Picture bird3 = new Picture("birdPuzzle.jpg");
        bird3.grayScale();
        bird3.mirrorDiagonal();
        bird.cropAndCopy(bird3, 150, 300, 150, 340, 70,150);
        
        //Mirror diagonal
        Picture beach = new Picture("beach.jpg");
        beach.mirrorDiagonal();
        beach.mirrorHorizontal();
        bird.cropAndCopy(beach, 330, 438, 0, 505, 330, 0);
        
        bird.explore();
        bird.write("c:\\APCS\\mycollage.jpg");
    }
}
