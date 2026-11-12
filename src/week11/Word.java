package week11;

public class Word {
    String eng;
    String kor;

    public Word(String eng, String kor) {
        this.eng = eng;
        this.kor = kor;
    }

    @Override
    public String toString() {
        return eng + " : " + kor;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Word) {
            Word w = (Word) obj;
            return this.eng.equals(w.eng) && this.kor.equals(w.kor);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.eng.hashCode() + this.kor.hashCode();
    }
}
