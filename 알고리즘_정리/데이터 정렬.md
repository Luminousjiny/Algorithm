# ✅ 데이터 정렬   

### 1. comparable
> 기본적인 정렬       
> Comparable 인터페이스 implement 후 사용      

#### ✔ Arrays.sort() : 배열타입 정렬
> 기본 정렬 기준     
> 오름차순 정렬       
> 내림차순은 Collections.reverseOrder() 사용     
```java
Arrays.sort(arr);
Arrays.sort(arr,Collections.reverseOrder());
```     

#### ✔ Arrays.sort() : 객체타입 정렬     
> compareTo() 메서드를 재정의 해야함.     

```java 
static class Alpha implements Comparable<Alpha> {
        int id;
        char c;
        String s;
        Alpha(int id, char c, String s){
            this.id = id;
            this.c = c;
            this.s = s;
        }

        @Override
        public int compareTo(Alpha o) {
            if(this.c == o.c) return this.s.compareTo(o.s); // 만약 c가 같으면 s기준 오름차순
            return Integer.compare(this.c, o.c); // 오름차순, 반대로 하면 내림차순
            // String 형식의 비교는 compare 사용 불가, compareTo 사용해야 함
        }
    }
```     


### 2. comparator
> 기본 정렬 기준과 다르게 정렬하고 싶을 때     
> 2차원 배열은 comparator만 가능함!    

```java
static class StudentComparator implements Comparator<Student> { 

		@Override
		public int compare(Student o1, Student o2) { // 도우미 입력 받음
			return o1.no - o2.no;
			return -(o1.no - o2.no); // 데이터가 양 음수가 섞이지 않을 때
			return Integer.compare(this.no, o.no); // 양음수가 섞여있을 때 -> 언더플로우/ 오버플로우 방지!!!!
		} // 마지막 방법으로 모두 사용하기 !

	}
```    

#### ✔ CompareTo와 Compare 둘 다 return 값의 의미는 같음
