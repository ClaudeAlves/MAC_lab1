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
	652.7 ko vs 1.4 Mo so 1400ko so the size did more than doubled
