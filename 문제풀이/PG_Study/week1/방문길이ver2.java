package study_week1;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class 방문길이ver2 {
    public int solution(String dirs) {
        Set<Point> set = new HashSet<>();
        int sx = 0; int sy = 0;
        for(int i=0; i<dirs.length(); i++){
            char c = dirs.charAt(i);
            if(c == 'U'){ // 작은 게 앞
                if(sx+1>5) continue;
                set.add(new Point(sx, sy, sx+1, sy));
                sx++;
            }else if(c == 'D'){
                if(sx-1<-5) continue;
                set.add(new Point(sx-1, sy, sx, sy));
                sx--;
            }else if(c == 'R'){
                if(sy+1>5) continue;
                set.add(new Point(sx, sy, sx, sy+1));
                sy++;
            }else if(c == 'L'){
                if(sy-1<-5) continue;
                set.add(new Point(sx, sy-1, sx, sy));
                sy--;
            }
        }
        return set.size();
    }
    class Point{
        int x1, y1, x2, y2;
        Point(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x1 == point.x1 && y1 == point.y1 && x2 == point.x2 && y2 == point.y2;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
}
