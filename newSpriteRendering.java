class newSpriteRendering{
    public static String grey = "\u001B[40m ";
    public static String red = "\u001B[41m ";
    
    public static String[] pixels = new String[16 * 16];
    public static void main(String[] args){
        int[][] triangle = {{0, 0, 0, 1},
                            {0, 0, 1, 1},
                            {0, 1, 1, 1},
                            {1, 1, 1, 1}};

        int[][] smile = {{0, 0, 0, 0, 0},
                         {0, 1, 0, 1, 0},
                         {0, 0, 0, 0, 0},
                         {1, 0, 0, 0, 1},
                         {0, 1, 1, 1, 0}};
        
        for (int i = 0; i < pixels.length; i++){
            pixels[i] = grey;
        }

        drawSprite(triangle, 0, -5, false, true);
        drawSprite(triangle, 4, -5, true, true);
        drawSprite(triangle, 0, -9, false, false);
        drawSprite(triangle, 4, -9, true, false);
        drawSprite(smile, 9, -7, false, true);
        
        for (int i = 0; i < 16; i++){
            for (int j = 0; j < 16; j++){
                System.out.print(pixels[i * 16 + j]);
            }
            System.out.println("\u001B[0m");
        }
    }

    static void setPixel(int x, int y, String color){
        pixels[Math.abs(y) * 16 + x] = color;
    }

    static void drawSprite(int[][] sprite, int x, int y, boolean hFlip, boolean vFlip){
        for (int i = y; i < y + sprite.length; i++){
            for (int j = x; j < x + sprite[0].length; j++){
                if (!hFlip && !vFlip){
                    switch(sprite[i-y][j-x]){
                        case 0: setPixel(j, i, grey);
                        break;
                        case 1: setPixel(j, i, red);
                        break;
                    }
                }
                else if (hFlip && !vFlip){
                    switch(sprite[i-y][Math.abs(j-(x+(sprite[0].length-1)))]){
                        case 0: setPixel(j, i, grey);
                        break;
                        case 1: setPixel(j, i, red);
                        break;
                    }
                }
                else if (!hFlip && vFlip){
                    switch(sprite[Math.abs(i-(y+(sprite.length-1)))][j-x]){
                        case 0: setPixel(j, i, grey);
                        break;
                        case 1: setPixel(j, i, red);
                        break;
                    }
                }
                else if (hFlip && vFlip){
                    switch(sprite[Math.abs(i-(y+(sprite.length-1)))][Math.abs(j-(x+(sprite[0].length-1)))]){
                        case 0: setPixel(j, i, grey);
                        break;
                        case 1: setPixel(j, i, red);
                        break;
                    }
                }
            }
        }
    }
}