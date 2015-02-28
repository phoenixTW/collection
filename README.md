# collection
Java utils

##Version 1.0
	
	- List<E> map(List<E>, ListMapper);
	- List<E> filter(List<E>, ListFilter );


```sh
	
	ListMapper is a interface. mapCallback() is method signature which will take
		E element, int count and List<E>

```
```sh
	
	ListFilter is a interface. filterCallback() is method signature which will take
		E element, int count and List<E>

```

##Version 2.0

	- List<K> map(List<E>, ListMapper<E,K>);
	- where E and K are same or different classes