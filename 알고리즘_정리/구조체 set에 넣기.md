# 구조체 set에 넣기
> set은 구조체 비교를 못한다.    
> 따라서 equals()와 hashcode() 메소드를 재정의(@Override)해줘야 한다.    

```java
    static class Point{
        int x1, y1, x2, y2;
        Point(int x1, int y1, int x2, int y2){
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true; // 1. 주소값이 같은지
            if (o == null || getClass() != o.getClass()) return false; // null이 아닌지 || 클래스 타입이 같은지
            Point point = (Point) o;
            return x1 == point.x1 && y1 == point.y1 && x2 == point.x2 && y2 == point.y2; // 각 값이 같은지
        }

        @Override
        public int hashCode() {
            return Objects.hash(x1, y1, x2, y2);
        }
    }
```
