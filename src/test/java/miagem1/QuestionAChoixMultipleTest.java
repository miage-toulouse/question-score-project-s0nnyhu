package miagem1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class QuestionAChoixMultipleTest {

    private QuestionAChoixMultiple question;
    private List<Integer> list;
    @Before
    public void setUp() throws Exception {
        // given : une instance de question à choix multiple avec la liste des indices pour les bonnes réponses
        this.list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        this.question = new QuestionAChoixMultiple("un énoncé", list);
    }

    @Test
    public void testGetEnonce() {
        // when : on demande son éoncé à la question
        String resEnonce = question.getEnonce();
        // then : l'énoncé retourné est l'énoncé fourni à la construction de la question
        assertEquals("un énoncé", resEnonce);
    }

    @Test
    public void testGetScoreForIndiceBonneReponse() {
        // when : quand l'étudiant fourni les indices de la bonne réponse
        int firstIndiceEtudiant = 1;
        int secIndiceEtudiant = 2;
        // and : on demande le score de chaque indice à la question
        float resScore = this.question.getScoreForIndice(firstIndiceEtudiant);
        resScore = resScore + this.question.getScoreForIndice(secIndiceEtudiant);
        // then : le score obtenu est 100
        assertEquals(100f, resScore, 0.001f);
    }

    @Test
    public void testGetScoreForIndiceMauvaiseReponse() {
        // when : quand l'étudiant fourni les indices de la bonne réponse
        int firstIndiceEtudiant = 0;
        int secIndiceEtudiant = 3;
        // and : on demande le score de chaque indice à la question
        float resScore = this.question.getScoreForIndice(firstIndiceEtudiant);
        resScore = resScore + this.question.getScoreForIndice(secIndiceEtudiant);
        // then : le score obtenu est 100
        assertEquals(0f, resScore, 0.001f);
    }
}