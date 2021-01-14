# 정렬(Sorting)    
### 1. Arrays.sort()   
##### int형 배열 정렬   
- 오름차순 .. 기본   
```java
int[] arr = {1, 26, 17, 25, 99, 44, 303};
Arrays.sort(arr);
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [1, 17, 25, 26, 44, 99, 303]
```   

- 내림차순   
> sort()의 인자에 추가로 Collections.reverseOrder() 해야함.     
```java
Integer[] arr = {1, 26, 17, 25, 99, 44, 303};
Arrays.sort(arr, Collections.reverseOrder());
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [303, 99, 44, 26, 25, 17, 1]   
```    
---   
- 부분정렬    
> Arrays.sort(배열, 시작, 끝 index)    
```java   
int[] arr = {1, 26, 17, 25, 99, 44, 303};
Arrays.sort(arr, 0, 4);
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [1, 17, 25, 26, 99, 44, 303]
```   
---   

##### String형 배열 정렬    
> int형과 동일    
> 아스키코드 값으로 비교하여 정렬함    
- 오름차순   
```java   
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
Arrays.sort(arr);
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [Apple, Banana, Cherry, Kiwi, Orange, Watermelon]
```   

- 내림차순   
```java   
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};
Arrays.sort(arr, Collections.reverseOrder());
System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text   
// OUTPUT : 
Sorted arr[] : [Watermelon, Orange, Kiwi, Cherry, Banana, Apple]
```   
---   
- 문자열 길이 순서로 정리   
```java 
String[] arr = {"Apple", "Kiwi", "Orange", "Banana", "Watermelon", "Cherry"};

Arrays.sort(arr, new Comparator<String>() {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();
    }
});

System.out.println("Sorted arr[] : " + Arrays.toString(arr));
```   
```text
// OUTPUT : 
Sorted arr[] : [Kiwi, Apple, Orange, Banana, Cherry, Watermelon]
```   
---   

##### 객체 배열 정렬    
> 이 경우에는 클래스에 Comparable을 구현하여 비교할 수 있게 해야 한다.   
```java   
static class Times implements Comparable<Times>{ //사용예시
		int start;
		int end;
		
		public Times(int start, int end) {
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "Time [start=" + start + ", end=" + end + "]";
		}

		@Override
		public int compareTo(Times o) {
			return Integer.compare(this.start, o.start); //시작기준 오름차순
		}
	}
```   

---   
[참고자료] https://codechacha.com/ko/java-sorting-array/   

