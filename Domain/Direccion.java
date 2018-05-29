package Domain;

public class Direccion {
    
//ACOMODAR
    
    public static char getDireccion(double x, double y, char actual) {//x,y interseccion

        if (0 <= x && x <= 27 && 0 <= y && y <= 1) { // a
            return 'e';
        }
        if (634 <= x && x <= 657 && 0 <= y && y <= 27) { // b
            return 's';
        }
        
        if (634 <= x && x <= 657 && 494 <= y && y <= 519) { // c
            return 'w';
        }
        if (0 <= x && x <= 1 && 494 <= y && y <= 519) { // d
            return 'n';
        }

//        if(120 <= x && x <= 144 && 0 <= y && y <= 27){ // e
//            return 's';
//        }
        
        if (120 <= x && x <= 121 && 494 <= y && y <= 519) { // f
            return 'n';
        }

//        if (519 <= x && x <= 543 && 0 <= y && y <= 27) { // g
//            return 's';
//        }

//        if(519 <= x && x <= 543 && 122 <= y && y <= 123){ // h
//            return 'w';
//        }

        if(634 <= x && x <= 657 && 122 <= y && y <= 147){ // i
            return 'w';
        }

        if(120 <= x && x <= 144 && 122 <= y && y <= 147){ // j
            return 'w';
        }
        
        if (0 <= x && x <= 1 && 122 <= y && y <= 147) { // k
            return 'n';
        }

        if (0 <= x && x <= 27 && 376 <= y && y <= 377) { // l
            return 'e';
        }

        if (0 <= x && x <= 27 && 260 <= y && y <= 261) { // m
            return 'e';
        }

        if (634 <= x && x <= 657 && 260 <= y && y <= 286) { // n
            return 's';
        }

        if (634 <= x && x <= 657 && 376 <= y && y <= 404) { // o
            return 's';
        }

//        if (519 <= x && x <= 543 && 376 <= y && y <= 404) { // p
//            return 'n';
//        }

        if (519 <= x && x <= 543 && 260 <= y && y <= 261) { // q
            return 'e';
        }

//        if(120 <= x && x <= 144 && 376 <= y && y <= 377){ // r
//            return 'e';
//        }

//        if (261 <= x && x <= 286 && 376 <= y && y <= 377) { // s
//            return 'e';
//        }

        if(261 <= x && x <= 262 && 494 <= y && y <= 519){ // t
            return 'n';
        }
        
//        if(519 <= x && x <= 520 && 494 <= y && y <= 519){ // v
//            return 'n';
//        }

//        if (403 <= x && x <= 421 && 376 <= y && y <= 377) { // w
//            return 'e';
//        }

        if (403 <= x && x <= 404 && 494 <= y && y <= 519) { // x
            return 'n';
        }

        if (120 <= x && x <= 144 && 260 <= y && y <= 261) { // y
            return 'e';
        }

//        if (634 <= x && x <= 657 && 238 <= y && y <= 260) { // z
//            return 'w';
//        }

        if (0 <= x && x <= 1 && 238 <= y && y <= 260) { // aa
            return 'n';
        }

        if (519 <= x && x <= 543 && 238 <= y && y <= 260) { // bb
            return 'w';
        }

//        if(238 <= x && x <= 261 && 0 <= y && y <= 27){ // cc
//            return 's';
//        }

        if (238 <= x && x <= 261 && 494 <= y && y <= 519) { // dd
            return 'w';
        }

        if (238 <= x && x <= 261 && 376 <= y && y <= 377) { // ee
            return 'e';
        }

//        if (238 <= x && x <= 261 && 122 <= y && y <= 147) { // ff
//            return 'w';
//        }

//        if (378 <= x && x <= 403 && 0 <= y && y <= 27) { // gg
//            return 's';
//        }

        if (378 <= x && x <= 403 && 494 <= y && y <= 519) { // hh
            return 'w';
        }

//        if (378 <= x && x <= 403 && 376 <= y && y <= 377) { // ii
//            return 'e';
//        }

//        if (378 <= x && x <= 403 && 122 <= y && y <= 147) { // jj
//            return 'w';
//        }

        if (120 <= x && x <= 144 && 238 <= y && y <= 260) { // kk
            return 'w';
        }

        if(261 <= x && x <= 286 && 0 <= y && y <= 1){ // ll
            return 'e';
        }
        
//        if(403 <= x && x <= 421 && 122 <= y && y <= 123){ // mm
//            return 'w';
//        }
        
        if (403 <= x && x <= 421 && 0 <= y && y <= 1) { // nn
            return 'e';
        }

        if (261 <= x && x <= 286 && 122 <= y && y <= 123) { // oo
            return 'w';
        }
        
        return actual;
    }
}
