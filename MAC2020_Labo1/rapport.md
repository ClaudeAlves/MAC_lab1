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
