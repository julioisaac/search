package br.com.luizalabs.index.indexer.transformers.stopwords;

import java.util.HashMap;

public class StopWords {

    private final HashMap<String, Boolean> wordsTable;
    private static StopWords instance;

    public StopWords() {
        wordsTable = new HashMap<>();
        wordsTable.put("0", true);
        wordsTable.put("1", true);
        wordsTable.put("2", true);
        wordsTable.put("3", true);
        wordsTable.put("4", true);
        wordsTable.put("5", true);
        wordsTable.put("6", true);
        wordsTable.put("7", true);
        wordsTable.put("8", true);
        wordsTable.put("9", true);
        wordsTable.put("_", true);
        wordsTable.put("-", true);

        // stop words inglês
        wordsTable.put("about", true);
        wordsTable.put("above", true);
        wordsTable.put("after", true);
        wordsTable.put("again", true);
        wordsTable.put("against", true);
        wordsTable.put("all", true);
        wordsTable.put("am", true);
        wordsTable.put("an", true);
        wordsTable.put("and", true);
        wordsTable.put("any", true);
        wordsTable.put("are", true);
        wordsTable.put("aren't", true);
        wordsTable.put("at", true);
        wordsTable.put("be", true);
        wordsTable.put("because", true);
        wordsTable.put("been", true);
        wordsTable.put("before", true);
        wordsTable.put("being", true);
        wordsTable.put("below", true);
        wordsTable.put("between", true);
        wordsTable.put("both", true);
        wordsTable.put("but", true);
        wordsTable.put("by", true);
        wordsTable.put("can't", true);
        wordsTable.put("cannot", true);
        wordsTable.put("could", true);
        wordsTable.put("couldn't", true);
        wordsTable.put("did", true);
        wordsTable.put("didn't", true);
        wordsTable.put("does", true);
        wordsTable.put("doesn't", true);
        wordsTable.put("doing", true);
        wordsTable.put("don't", true);
        wordsTable.put("down", true);
        wordsTable.put("during", true);
        wordsTable.put("each", true);
        wordsTable.put("few", true);
        wordsTable.put("from", true);
        wordsTable.put("further", true);
        wordsTable.put("had", true);
        wordsTable.put("hadn't", true);
        wordsTable.put("has", true);
        wordsTable.put("hasn't", true);
        wordsTable.put("have", true);
        wordsTable.put("haven't", true);
        wordsTable.put("having", true);
        wordsTable.put("he", true);
        wordsTable.put("he'd", true);
        wordsTable.put("he'll", true);
        wordsTable.put("he's", true);
        wordsTable.put("her", true);
        wordsTable.put("here", true);
        wordsTable.put("here's", true);
        wordsTable.put("hers", true);
        wordsTable.put("herself", true);
        wordsTable.put("him", true);
        wordsTable.put("himself", true);
        wordsTable.put("his", true);
        wordsTable.put("how", true);
        wordsTable.put("how's", true);
        wordsTable.put("i", true);
        wordsTable.put("i'd", true);
        wordsTable.put("i'll", true);
        wordsTable.put("i'm", true);
        wordsTable.put("i've", true);
        wordsTable.put("if", true);
        wordsTable.put("in", true);
        wordsTable.put("into", true);
        wordsTable.put("is", true);
        wordsTable.put("isn't", true);
        wordsTable.put("it", true);
        wordsTable.put("it's", true);
        wordsTable.put("its", true);
        wordsTable.put("itself", true);
        wordsTable.put("let's", true);
        wordsTable.put("more", true);
        wordsTable.put("most", true);
        wordsTable.put("mustn't", true);
        wordsTable.put("my", true);
        wordsTable.put("myself", true);
        wordsTable.put("nor", true);
        wordsTable.put("not", true);
        wordsTable.put("of", true);
        wordsTable.put("off", true);
        wordsTable.put("on", true);
        wordsTable.put("once", true);
        wordsTable.put("only", true);
        wordsTable.put("or", true);
        wordsTable.put("other", true);
        wordsTable.put("ought", true);
        wordsTable.put("our", true);
        wordsTable.put("ours ", true);
        wordsTable.put("ourselves", true);
        wordsTable.put("out", true);
        wordsTable.put("over", true);
        wordsTable.put("own", true);
        wordsTable.put("same", true);
        wordsTable.put("shan't", true);
        wordsTable.put("she", true);
        wordsTable.put("she'd", true);
        wordsTable.put("she'll", true);
        wordsTable.put("she's", true);
        wordsTable.put("should", true);
        wordsTable.put("shouldn't", true);
        wordsTable.put("so", true);
        wordsTable.put("some", true);
        wordsTable.put("say", true);
        wordsTable.put("said", true);
        wordsTable.put("such", true);
        wordsTable.put("than", true);
        wordsTable.put("that", true);
        wordsTable.put("that's", true);
        wordsTable.put("the", true);
        wordsTable.put("their", true);
        wordsTable.put("theirs", true);
        wordsTable.put("them", true);
        wordsTable.put("themselves", true);
        wordsTable.put("then", true);
        wordsTable.put("there", true);
        wordsTable.put("there's", true);
        wordsTable.put("these", true);
        wordsTable.put("they", true);
        wordsTable.put("they'd", true);
        wordsTable.put("they'll", true);
        wordsTable.put("they're", true);
        wordsTable.put("they've", true);
        wordsTable.put("this", true);
        wordsTable.put("those", true);
        wordsTable.put("through", true);
        wordsTable.put("to", true);
        wordsTable.put("too", true);
        wordsTable.put("under", true);
        wordsTable.put("until", true);
        wordsTable.put("up", true);
        wordsTable.put("very", true);
        wordsTable.put("was", true);
        wordsTable.put("wasn't", true);
        wordsTable.put("we", true);
        wordsTable.put("we'd", true);
        wordsTable.put("we'll", true);
        wordsTable.put("we're", true);
        wordsTable.put("we've", true);
        wordsTable.put("were", true);
        wordsTable.put("weren't", true);
        wordsTable.put("what", true);
        wordsTable.put("what's", true);
        wordsTable.put("when", true);
        wordsTable.put("when's", true);
        wordsTable.put("where", true);
        wordsTable.put("where's", true);
        wordsTable.put("which", true);
        wordsTable.put("while", true);
        wordsTable.put("who", true);
        wordsTable.put("who's", true);
        wordsTable.put("whom", true);
        wordsTable.put("why", true);
        wordsTable.put("why's", true);
        wordsTable.put("with", true);
        wordsTable.put("won't", true);
        wordsTable.put("would", true);
        wordsTable.put("wouldn't", true);
        wordsTable.put("you", true);
        wordsTable.put("you'd", true);
        wordsTable.put("you'll", true);
        wordsTable.put("you're", true);
        wordsTable.put("you've", true);
        wordsTable.put("your", true);
        wordsTable.put("yours", true);
        wordsTable.put("yourself", true);
        wordsTable.put("yourselves ", true);

        // stop words espanhol
        wordsTable.put("un", true);
        wordsTable.put("una", true);
        wordsTable.put("unas", true);
        wordsTable.put("unos", true);
        wordsTable.put("uno", true);
        wordsTable.put("sobre", true);
        wordsTable.put("todo", true);
        wordsTable.put("también", true);
        wordsTable.put("tras", true);
        wordsTable.put("otro", true);
        wordsTable.put("algún", true);
        wordsTable.put("alguno", true);
        wordsTable.put("alguna", true);
        wordsTable.put("algunos", true);
        wordsTable.put("algunas", true);
        wordsTable.put("es", true);
        wordsTable.put("soy", true);
        wordsTable.put("eres", true);
        wordsTable.put("somos", true);
        wordsTable.put("sois", true);
        wordsTable.put("estoy", true);
        wordsTable.put("esta", true);
        wordsTable.put("estamos", true);
        wordsTable.put("estais", true);
        wordsTable.put("estan", true);
        wordsTable.put("como", true);
        wordsTable.put("en", true);
        wordsTable.put("atras", true);
        wordsTable.put("porque", true);
        wordsTable.put("qué", true);
        wordsTable.put("estado", true);
        wordsTable.put("estaba", true);
        wordsTable.put("ante", true);
        wordsTable.put("antes", true);
        wordsTable.put("siendo", true);
        wordsTable.put("ambos", true);
        wordsTable.put("pero", true);
        wordsTable.put("por", true);
        wordsTable.put("poder", true);
        wordsTable.put("puede", true);
        wordsTable.put("puedo", true);
        wordsTable.put("podemos", true);
        wordsTable.put("podeis", true);
        wordsTable.put("pueden", true);
        wordsTable.put("fui", true);
        wordsTable.put("fue", true);
        wordsTable.put("fuimos", true);
        wordsTable.put("fueron", true);
        wordsTable.put("hacer", true);
        wordsTable.put("hago", true);
        wordsTable.put("hace", true);
        wordsTable.put("hacemos", true);
        wordsTable.put("haceis", true);
        wordsTable.put("hacen", true);
        wordsTable.put("cada", true);
        wordsTable.put("fin", true);
        wordsTable.put("incluso", true);
        wordsTable.put("primero", true);
        wordsTable.put("desde", true);
        wordsTable.put("conseguir", true);
        wordsTable.put("consigo", true);
        wordsTable.put("consigue", true);
        wordsTable.put("consigues", true);
        wordsTable.put("conseguimos", true);
        wordsTable.put("consiguen", true);
        wordsTable.put("ir", true);
        wordsTable.put("voy", true);
        wordsTable.put("va", true);
        wordsTable.put("vamos", true);
        wordsTable.put("vais", true);
        wordsTable.put("van", true);
        wordsTable.put("vaya", true);
        wordsTable.put("gueno", true);
        wordsTable.put("ha", true);
        wordsTable.put("tener", true);
        wordsTable.put("tengo", true);
        wordsTable.put("tiene", true);
        wordsTable.put("tenemos", true);
        wordsTable.put("teneis", true);
        wordsTable.put("tienen", true);
        wordsTable.put("el", true);
        wordsTable.put("la", true);
        wordsTable.put("lo", true);
        wordsTable.put("las", true);
        wordsTable.put("los", true);
        wordsTable.put("su", true);
        wordsTable.put("aqui", true);
        wordsTable.put("mio", true);
        wordsTable.put("tuyo", true);
        wordsTable.put("ellos", true);
        wordsTable.put("ellas", true);
        wordsTable.put("nos", true);
        wordsTable.put("nosotros", true);
        wordsTable.put("vosotros", true);
        wordsTable.put("vosotras", true);
        wordsTable.put("si", true);
        wordsTable.put("dentro", true);
        wordsTable.put("solo", true);
        wordsTable.put("solamente", true);
        wordsTable.put("saber", true);
        wordsTable.put("sabes", true);
        wordsTable.put("sabe", true);
        wordsTable.put("sabemos", true);
        wordsTable.put("sabeis", true);
        wordsTable.put("saben", true);
        wordsTable.put("ultimo", true);
        wordsTable.put("largo", true);
        wordsTable.put("bastante", true);
        wordsTable.put("haces", true);
        wordsTable.put("muchos", true);
        wordsTable.put("aquellos", true);
        wordsTable.put("aquellas", true);
        wordsTable.put("sus", true);
        wordsTable.put("entonces", true);
        wordsTable.put("tiempo", true);
        wordsTable.put("verdad", true);
        wordsTable.put("verdadero", true);
        wordsTable.put("verdadera", true);
        wordsTable.put("cierto", true);
        wordsTable.put("ciertos", true);
        wordsTable.put("cierta", true);
        wordsTable.put("ciertas", true);
        wordsTable.put("intentar", true);
        wordsTable.put("intento", true);
        wordsTable.put("intenta", true);
        wordsTable.put("intentas", true);
        wordsTable.put("intentamos", true);
        wordsTable.put("intentais", true);
        wordsTable.put("intentan", true);
        wordsTable.put("dos", true);
        wordsTable.put("bajo", true);
        wordsTable.put("arriba", true);
        wordsTable.put("encima", true);
        wordsTable.put("usar", true);
        wordsTable.put("uso", true);
        wordsTable.put("usas", true);
        wordsTable.put("usa", true);
        wordsTable.put("usamos", true);
        wordsTable.put("usais", true);
        wordsTable.put("usan", true);
        wordsTable.put("emplear", true);
        wordsTable.put("empleo", true);
        wordsTable.put("empleas", true);
        wordsTable.put("emplean", true);
        wordsTable.put("ampleamos", true);
        wordsTable.put("empleais", true);
        wordsTable.put("valor", true);
        wordsTable.put("muy", true);
        wordsTable.put("era", true);
        wordsTable.put("eras", true);
        wordsTable.put("eramos", true);
        wordsTable.put("eran", true);
        wordsTable.put("modo", true);
        wordsTable.put("bien", true);
        wordsTable.put("cual", true);
        wordsTable.put("cuando", true);
        wordsTable.put("donde", true);
        wordsTable.put("mientras", true);
        wordsTable.put("quien", true);
        wordsTable.put("con", true);
        wordsTable.put("entre", true);
        wordsTable.put("sin", true);
        wordsTable.put("trabajo", true);
        wordsTable.put("trabajar", true);
        wordsTable.put("trabajas", true);
        wordsTable.put("trabaja", true);
        wordsTable.put("trabajamos", true);
        wordsTable.put("trabajais", true);
        wordsTable.put("trabajan", true);
        wordsTable.put("podria", true);
        wordsTable.put("podrias", true);
        wordsTable.put("podriamos", true);
        wordsTable.put("podrian", true);
        wordsTable.put("podriais", true);
        wordsTable.put("yo", true);
        wordsTable.put("aquel", true);

        // stop words português
        wordsTable.put("de", true);
        wordsTable.put("a", true);
        wordsTable.put("o", true);
        wordsTable.put("que", true);
        wordsTable.put("e", true);
        wordsTable.put("do", true);
        wordsTable.put("da", true);
        wordsTable.put("em", true);
        wordsTable.put("um", true);
        wordsTable.put("para", true);
        wordsTable.put("é", true);
        wordsTable.put("com", true);
        wordsTable.put("não", true);
        wordsTable.put("uma", true);
        wordsTable.put("os", true);
        wordsTable.put("no", true);
        wordsTable.put("se", true);
        wordsTable.put("na", true);
        wordsTable.put("mais", true);
        wordsTable.put("as", true);
        wordsTable.put("mas", true);
        wordsTable.put("foi", true);
        wordsTable.put("ao", true);
        wordsTable.put("ele", true);
        wordsTable.put("das", true);
        wordsTable.put("tem", true);
        wordsTable.put("à", true);
        wordsTable.put("seu", true);
        wordsTable.put("sua", true);
        wordsTable.put("ou", true);
        wordsTable.put("ser", true);
        wordsTable.put("quando", true);
        wordsTable.put("muito", true);
        wordsTable.put("já", true);
        wordsTable.put("está", true);
        wordsTable.put("eu", true);
        wordsTable.put("também", true);
        wordsTable.put("só", true);
        wordsTable.put("pelo", true);
        wordsTable.put("pela", true);
        wordsTable.put("até", true);
        wordsTable.put("isso", true);
        wordsTable.put("ela", true);
        wordsTable.put("depois", true);
        wordsTable.put("sem", true);
        wordsTable.put("mesmo", true);
        wordsTable.put("aos", true);
        wordsTable.put("ter", true);
        wordsTable.put("seus", true);
        wordsTable.put("quem", true);
        wordsTable.put("nas", true);
        wordsTable.put("me", true);
        wordsTable.put("esse", true);
        wordsTable.put("eles", true);
        wordsTable.put("você", true);
        wordsTable.put("foram", true);
        wordsTable.put("essa", true);
        wordsTable.put("num", true);
        wordsTable.put("nem", true);
        wordsTable.put("suas", true);
        wordsTable.put("meu", true);
        wordsTable.put("às", true);
        wordsTable.put("minha", true);
        wordsTable.put("têm", true);
        wordsTable.put("numa", true);
        wordsTable.put("pelos", true);
        wordsTable.put("elas", true);
        wordsTable.put("havia", true);
        wordsTable.put("qual", true);
        wordsTable.put("nós", true);
        wordsTable.put("lhe", true);
        wordsTable.put("deles", true);
        wordsTable.put("essas", true);
        wordsTable.put("esses", true);
        wordsTable.put("pelas", true);
        wordsTable.put("este", true);
        wordsTable.put("fosse", true);
        wordsTable.put("dele", true);
        wordsTable.put("tu", true);
        wordsTable.put("te", true);
        wordsTable.put("vocês", true);
        wordsTable.put("vos", true);
        wordsTable.put("lhes", true);
        wordsTable.put("meus", true);
        wordsTable.put("minhas", true);
        wordsTable.put("teu", true);
        wordsTable.put("tua", true);
        wordsTable.put("teus", true);
        wordsTable.put("tuas", true);
        wordsTable.put("nosso", true);
        wordsTable.put("nossa", true);
        wordsTable.put("nossos", true);
        wordsTable.put("nossas", true);
        wordsTable.put("dela", true);
        wordsTable.put("delas", true);
        wordsTable.put("estes", true);
        wordsTable.put("estas", true);
        wordsTable.put("aquele", true);
        wordsTable.put("aquela", true);
        wordsTable.put("aqueles", true);
        wordsTable.put("aquelas", true);
        wordsTable.put("isto", true);
        wordsTable.put("aquilo", true);
        wordsTable.put("estou", true);
        wordsTable.put("estão", true);
        wordsTable.put("estive", true);
        wordsTable.put("esteve", true);
        wordsTable.put("estivemos", true);
        wordsTable.put("estiveram", true);
        wordsTable.put("estava", true);
        wordsTable.put("estávamos", true);
        wordsTable.put("estavam", true);
        wordsTable.put("estivera", true);
        wordsTable.put("estivéramos", true);
        wordsTable.put("esteja", true);
        wordsTable.put("estejamos", true);
        wordsTable.put("estejam", true);
        wordsTable.put("estivesse", true);
        wordsTable.put("estivéssemos", true);
        wordsTable.put("estivessem", true);
        wordsTable.put("estiver", true);
        wordsTable.put("estivermos", true);
        wordsTable.put("estiverem", true);
        wordsTable.put("hei", true);
        wordsTable.put("há", true);
        wordsTable.put("havemos", true);
        wordsTable.put("hão", true);
        wordsTable.put("houve", true);
        wordsTable.put("houvemos", true);
        wordsTable.put("houveram", true);
        wordsTable.put("houvera", true);
        wordsTable.put("houvéramos", true);
        wordsTable.put("haja", true);
        wordsTable.put("hajamos", true);
        wordsTable.put("hajam", true);
        wordsTable.put("houvesse", true);
        wordsTable.put("houvéssemos", true);
        wordsTable.put("houvessem", true);
        wordsTable.put("houver", true);
        wordsTable.put("houvermos", true);
        wordsTable.put("houverem", true);
        wordsTable.put("houverei", true);
        wordsTable.put("houverá", true);
        wordsTable.put("houveremos", true);
        wordsTable.put("houverão", true);
        wordsTable.put("houveria", true);
        wordsTable.put("houveríamos", true);
        wordsTable.put("houveriam", true);
        wordsTable.put("sou", true);
        wordsTable.put("são", true);
        wordsTable.put("éramos", true);
        wordsTable.put("eram", true);
        wordsTable.put("fomos", true);
        wordsTable.put("fora", true);
        wordsTable.put("fôramos", true);
        wordsTable.put("seja", true);
        wordsTable.put("sejamos", true);
        wordsTable.put("sejam", true);
        wordsTable.put("fôssemos", true);
        wordsTable.put("fossem", true);
        wordsTable.put("for", true);
        wordsTable.put("formos", true);
        wordsTable.put("forem", true);
        wordsTable.put("serei", true);
        wordsTable.put("será", true);
        wordsTable.put("seremos", true);
        wordsTable.put("serão", true);
        wordsTable.put("seria", true);
        wordsTable.put("seríamos", true);
        wordsTable.put("seriam", true);
        wordsTable.put("tenho", true);
        wordsTable.put("temos", true);
        wordsTable.put("tém", true);
        wordsTable.put("tinha", true);
        wordsTable.put("tínhamos", true);
        wordsTable.put("tinham", true);
        wordsTable.put("tive", true);
        wordsTable.put("teve", true);
        wordsTable.put("tivemos", true);
        wordsTable.put("tiveram", true);
        wordsTable.put("tivera", true);
        wordsTable.put("tivéramos", true);
        wordsTable.put("tenha", true);
        wordsTable.put("tenhamos", true);
        wordsTable.put("tenham", true);
        wordsTable.put("tivesse", true);
        wordsTable.put("tivéssemos", true);
        wordsTable.put("tivessem", true);
        wordsTable.put("tiver", true);
        wordsTable.put("tivermos", true);
        wordsTable.put("tiverem", true);
        wordsTable.put("terei", true);
        wordsTable.put("terá", true);
        wordsTable.put("teremos", true);
        wordsTable.put("terão", true);
        wordsTable.put("teria", true);
        wordsTable.put("teríamos", true);
        wordsTable.put("teriam", true);
    }

    public boolean isStopWord(String s) {
        boolean ret = wordsTable.get(s) != null;
        if (s.length()==1) ret = true;
        return ret;
    }

    public static StopWords getInstance() {
        if (instance == null)
            instance = new StopWords();
        return instance;
    }
}
