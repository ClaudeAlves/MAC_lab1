MAC lab 1 questions
2.1
1. What are the types of the fields in the index?
	
2. What are the characteristics of each type of field in terms of indexing, storage and tokenization?
	IntPoint : indexes int values for efficient range filtering ans sorting
	StringField : this field is indexed but not tokenized, the entire string value is indexed as a single token
	TextField : indexed and tokenized, without term vectors
	Field : this one is for general purpose allows to specify name, value and type. to be used instead of TextField to be able to access the Term Vector
3. Does the command line demo use stopword removal? Explain how you find out the answer.
	it doesn't, i searched for "usa" and "the usa", different responses
4. Does the command line demo use stemming? Explain how you find out the answer.
	it doesn't, we tried with the queries long and longitude both queries gave us different responses
5. Is the search of the command line demo case insensitive? How did you find out the answer?
	yes it's case insensitive when you type USA it searches for usa so it makes the input lower case
6. Does it matter whether stemming occurs before or after stopword removal? Consider this as a general question.
	no because stopwords aren't root words so steeming doesn't apply to them and it won't impact either it's done before or after

3.1
1. Find out what is a “term vector” in Lucene vocabulary?
	Term vector is a list of that tells us the frequency, the offset and the position of the word it is attached to.
2. What should be added to the code to have access to the “term vector” in the index? Have a look at the
different methods of the class FieldType . Use Luke to check that the “term vector” is included in the
index.
	when declaring a field put Field.Store.YES as the "Store" argument

3. Compare the size of the index before and after enabling “term vector”, discuss the results.
	652.7 ko vs 1.4 Mo so 1400ko so the size did more than doubled with the term vector on
3.2
2. Explain the difference of these five analyzers.
	
3. Look at the index using Luke and for each created index find out the following information:
	a. The number of indexed documents and indexed terms.
	b. The number of indexed terms in the summary field.
	c. The top 10 frequent terms of the summary field in the index.
	d. The size of the index on disk.
	e. The required time for indexing (e.g. using System.currentTimeMillis() before and after the
indexing).

white space
	a. number of documents 3203 number of terms 34827
	b. number of terms in summary 26821
	c. the top 10 frequent terms in summary
		1 .of
		2 .the
		3 .is
		4 .a
		5 .and
		6 .to
		7 .in
		8 .for
		9 .The 	
		10.are
	d. 1.5Mo
	e. 1258 milliseconds

English
	a. number of documents 3203 number of terms 23010
	b. number of terms in summary 16724
	c. the top 10 frequent terms in summary
		1 .us
		2 .which
		3 .comput
		4 .program
		5 .system
		6 .present
		7 .describ
		8 .paper
		9 .method	 	
		10.can
	d. 1.3Mo
	e. 1526 milliseconds

Shingle 1 and 2
	a. number of documents 3203 number of terms 119846
	b. number of terms in summary 100768
	c. the top 10 frequent terms in summary
		1 .the
		2 .of
		3 .a
		4 .is
		5 .and
		6 .to
		7 .in
		8 .for
		9 .are 	
		10.of the
	d. 2.8Mo
	e. 2853 milliseconds

Shingle 1 and 3
	a. number of documents 3203 number of terms 251565
	b. number of terms in summary 218853
	c. the top 10 frequent terms in summary
		1 .the
		2 .of
		3 .a
		4 .is
		5 .and
		6 .to
		7 .in
		8 .for
		9 .are
		10.of the
	d. 5.0Mo
	e. 4067 milliseconds

stop
	a. number of documents 3203 number of terms 24663
	b. number of terms in summary 18342
	c. the top 10 frequent terms in summary
		1 .system
		2 .computer
		3 .paper
		4 .presented
		5 .time
		6 .method
		7 .program
		8 .data
		9 .algorithm
		10.discussed
	d. 1.3Mo
	e. 1841 milliseconds

4. Make 3 concluding statements bases on the above observations.
	1. the number of documents isn't analyzer dependant.
	2. the proportion of summary terms is more or less the same every time
	3. the top 10 terms in summary varies depending of the analyzer
	
