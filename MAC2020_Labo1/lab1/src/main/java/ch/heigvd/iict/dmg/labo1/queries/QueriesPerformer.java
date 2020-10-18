package ch.heigvd.iict.dmg.labo1.queries;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.index.DirectoryReader;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.misc.HighFreqTerms;
import org.apache.lucene.misc.TermStats;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.similarities.Similarity;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class QueriesPerformer {

    private final Analyzer analyzer;
    private IndexReader indexReader = null;
    private IndexSearcher indexSearcher = null;

    public QueriesPerformer(Analyzer analyzer, Similarity similarity) {
        this.analyzer = analyzer;
        Path path = FileSystems.getDefault().getPath("englishIndex");
        Directory dir;
        try {
            dir = FSDirectory.open(path);
            this.indexReader = DirectoryReader.open(dir);
            this.indexSearcher = new IndexSearcher(indexReader);
            if (similarity != null)
                this.indexSearcher.setSimilarity(similarity);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void printTopRankingTerms(String field, int numTerms) {
        // This methods print the top ranking term for a field.
        // See "Reading Index".

        TermStats[] termsTop;
        try {
            termsTop = HighFreqTerms.getHighFreqTerms(indexReader, numTerms, field, new HighFreqTerms.TotalTermFreqComparator());
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Top ranking terms for field [" + field + "] are: ");
        for (TermStats ts : termsTop) {
            System.out.println("\t" + ts);
        }
    }

    public void query(String q) {

        // See "Searching" section
        QueryParser queryParser = new QueryParser("summary", analyzer);
        Query query = null;
        try {
            query = queryParser.parse(q);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println("Searching for [" + q + "]");

        try {
            // search query
            ScoreDoc[] hits = indexSearcher.search(query, 1000).scoreDocs;
            // retrieve results
            for (ScoreDoc hit : hits) {
                Document doc = indexSearcher.doc(hit.doc);
                System.out.println(doc.get("id") + ": " + doc.get("title") + " (" +
                        hit.score + ")");
            }
            System.out.println("Results found: " + hits.length);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void close() {
        if (this.indexReader != null)
            try {
                this.indexReader.close();
            } catch (IOException e) { /* BEST EFFORT */ }
    }

}
