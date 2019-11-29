package miagem1;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ScoreCalculateurTest {

    private QuestionAChoixExclusif questionExclusif;
    private QuestionAChoixMultiple questionMultiple;
    private ScoreCalculateur scoreCalculateur;


    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple avec la liste des indices pour les bonnes réponses
        this.questionMultiple = new QuestionAChoixMultiple("un énoncé", new ArrayList<Integer>(Arrays.asList(2,3,5)));
        // given : une instance de score calculateur
        this.scoreCalculateur = new ScoreCalculateur();
    }

    @Test
    public void testCalculeScoreForQuestionMultipleForScoreZero() {
        // when : quand l'étudiant fourni les indices 1 et 4
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(1,4));
        // and : on demande le score de chaque indice à la question
        float resScore = this.scoreCalculateur.calculeScore(list, this.questionMultiple);
        // then : le score obtenu est 0
        assertEquals(0f, resScore, 0.001f);
    }

    @Test
    public void testCalculeScoreForQuestionMultipleForScoreIntermediate() {
        // when : quand l'étudiant fourni les indices 2 et 3
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3));
        // and : on demande le score de chaque indice à la question
        float resScore = this.scoreCalculateur.calculeScore(list, this.questionMultiple);
        // then : le score obtenu est 66.66
        float expectedScore = 2f*100f/3f;
        assertEquals(expectedScore, resScore, 0.01f);
    }

    @Test
    public void testCalculeScoreForQuestionMultipleForScorePerfect() {
        // when : quand l'étudiant fourni les indices 2, 3 et 5
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(2,3,5));
        // and : on demande le score de chaque indice à la question
        float resScore = this.scoreCalculateur.calculeScore(list, this.questionMultiple);
        // then : le score obtenu est 66.66
        assertEquals(100f, resScore, 0.01f);
    }
}