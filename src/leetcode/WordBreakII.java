package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import util.PrintUtil;

/**
 * For example, given s = "catsanddog", dict = ["cat", "cats", "and", "sand",
 * "dog"].
 * 
 * A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author yanfeixiang
 * 
 */
public class WordBreakII {
	public List<String> wordBreak(String s, Set<String> dict) {
		List<String> tmpList = new ArrayList<String>();
		Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

		wordBreak(tmpList, s, 0, dict, map);
		return map.get(0);

	}

	public void wordBreak(List<String> tmpList, String s, int i,
			Set<String> dict, Map<Integer, List<String>> map) {

		if (map.containsKey(i)) {
			for (String l : map.get(i)) {

				putMap(i, tmpList, map, " " + l);

			}

			return;
		}

		if (i == s.length()) {
			putMap(s.length(), tmpList, map, "");
			return;
		}

		for (int j = i + 1; j < s.length() + 1; j++) {
			if (dict.contains(s.substring(i, j))) {

				tmpList.add(s.substring(i, j));
				wordBreak(tmpList, s, j, dict, map);
				tmpList.remove(tmpList.size() - 1);

			}
		}

		if (!map.containsKey(i)) {
			map.put(i, new ArrayList<String>());
		}

	}

	private void putMap(int index, List<String> tmpList,
			Map<Integer, List<String>> map, String l) {
		String cur = l;

		for (int j = tmpList.size() - 1; j >= 0; j--) {
			cur = tmpList.get(j) + cur;
			index -= tmpList.get(j).length();
			if (map.containsKey(index)) {
				map.get(index).add(cur);
			} else {

				List<String> subList = new ArrayList<String>();

				subList.add(cur);
				map.put(index, subList);
			}
			cur = " " + cur;
		}

	}

	public static void main(String[] args) {
		long point1 = System.currentTimeMillis();
		Set<String> set = new HashSet<String>();
		set.add("a");
		set.add("aa");
		set.add("aaa");
		set.add("aaaa");
		set.add("aaaaa");
		set.add("aaaaaa");
		set.add("aaaaaaa");
		set.add("aaaaaaaa");
		set.add("aaaaaaaaa");
		set.add("aaaaaaaaaa");
		List<String> list;
		list = new WordBreakII()
				.wordBreak(
						"aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
						set);
		PrintUtil.printList(list);

		long point2 = System.currentTimeMillis();
		System.out.println(point2 - point1);

		set.clear();
		Collections.addAll(set, new String[] { "be", "ellaekgjhibcomc",
				"ahaklkan", "jcm", "lchidklmcone", "ljmdgagaen",
				"giioojldjkfnno", "el", "eibjaffacjll", "hn", "hbjakhjneml",
				"foi", "nbhf", "aigf", "cfdlnc", "fa", "amakgofedhkghgl",
				"ddhmhdhioh", "ijoddeabbiei", "giamcgco", "nholghlfbbendi",
				"emlc", "m", "elgibme", "behkignjenmh", "lodkkjgioe", "doe",
				"hgflgakna", "macghogdidmdm", "ec", "kncigolkog", "ljooio",
				"lch", "gkaclkbjn", "ofiaglfoffl", "alhfbb", "cfmdbgo",
				"cfcnajknk", "jfh", "almbgdjnbbbgmhb", "dmlnnohf",
				"olojeejfafc", "ndgcmgoe", "cmkdjilfeo", "bengdd", "enfg",
				"dbngiggni", "anmkljn", "njdnjdmmfha", "ndimmddfmhe",
				"hmkdjkhhiilnf", "ehd", "jfdl", "dlgki", "bhoflnomibkki", "lg",
				"fjojjnnkdfenhol", "lefhhl", "nimdl", "gejgomblmim",
				"ahbnlmlfmejjj", "glhacaojnf", "mfjdhnhdkm", "do", "fnh",
				"mnmjdk", "hfjgdlnnb", "hniolfhkhbie", "ldgodonogcab",
				"mabjnnohnijhn", "aceojlkmdg", "aedfljg", "cehk", "jag",
				"oniegflnhje", "jo", "maokc", "jkbndc", "djbn", "dajkdblojkf",
				"dmen", "kcdjdocinenc", "cgindbm", "h", "odaof", "cmogcbgj",
				"anjahlgbbmba", "haoe", "ggacnminj", "ilcfjoedhe",
				"klookammgofl", "onnmenn", "mbdneaioo", "jc", "dekgil",
				"bjdfibfd", "hfbnlgmlllcb", "afebehf", "obekljbnh", "eoaedhjk",
				"nobamccd", "mdieojoknf", "komcglmakkaa", "jcliimcc",
				"jmmgbmha", "gdogjnn", "ednembco", "dgno", "jiaheeabifahfmo",
				"djkcgnakkh", "kdkiglgf", "eb", "fmdnlhj", "eicohdciejc",
				"jgofmankkf", "o", "nnmomkmkmiaoga", "njchkccln", "ndamha",
				"eleanmojdi", "ebkl", "jcageehlelcg", "acfddofjihgmn",
				"iklaomfhjm", "io", "igmob", "lfnhnlnigbbignk", "anihfojmedf",
				"nj", "oilcabalhb", "adjfbkfjch", "lbfb", "mgfnngfccb",
				"jhmhggm", "dnllc", "c", "ljim", "jmikd", "mdfimdgac",
				"fhbclgo", "edclcdia", "nelmfjejff", "i", "cmcbbckdnjcoo",
				"cddocce", "hc", "keh", "keofhnhemd", "biln", "mjcnbjmkikon",
				"fekbdnkolahh", "hkfmjbj", "mjoj", "jn", "ilof", "ifhfk",
				"aofmg", "nofljgmmmf", "hcdifeiclbchlf", "imlijgdg",
				"ocdiiemcmbkglm", "nhoekmlkjfoa", "kibffkbleedda",
				"kdhdjekccbkc", "bcbflcag", "jekmkdimnnjjoo", "mmgfljchalbem",
				"kchk", "oi", "ncf", "jembgfa", "l", "kfkeianmmmdacl",
				"ecjkkfggj", "jdgcfnhfjonkhig", "jhagiokii", "nifm", "bbjjlj",
				"adajlokomibfg", "ojk", "lockdel", "bh", "hoojolglchck",
				"conko", "eadi", "kfigoijnfimolen", "g", "dbnj", "cojkbmo",
				"hh", "mcdbh", "ngdmgioen", "ehjagfohnolkho", "dgfgdlc",
				"aoglneoh", "gbc", "ijjckddeicld", "imekih", "liiaecniil",
				"hahejbhgiclb", "fnmojm", "ablihjhggiahhno", "colloaakco",
				"jhobddaanbhmlg", "cbfajfhkoh", "cim", "laghknigabn",
				"dcbnbkegkjam", "gem", "ljjim", "icclogji", "omidhe", "f",
				"giiaclfcjkagl", "ndcjldekjnkekm", "aiikdccohcj", "mkbmb",
				"oomhhafobic", "bkacdjfgbggn", "ahghdoahbi", "hedm", "eeoj",
				"bdgdlfollegej", "eg", "dfeb", "dkffkid", "hcne",
				"gjkohnaaabn", "jfeododjgdhlfbf", "clfkmconnkfb", "abnbkcni",
				"hk", "ghnmhjm", "oibjibmkaibdefa", "hjambim", "oe", "aao",
				"jil", "fmhomflfen", "hlidcklnmb", "hiaonkhd", "bibbmkandf",
				"hke", "bmfcionm", "inhcnlkbkkmjicn", "jckjedhgoghi", "chmik",
				"mnjldknhaec", "hocbccbg", "ljadj", "lciikgnlj",
				"ifjjhkbhifione", "foikblanoco", "ode", "mjc", "fhklofh",
				"mmoklkkog", "hocbojmhffeajo", "ccmmd", "bkkh",
				"nhhgcflniebkme", "lfohikenfbjacli", "cmehijnihijgng", "caa",
				"bmk", "emofof", "jjagiogohfab", "ibh", "eoacdlnodalkjbl",
				"cbbjbbnjom", "iljiomeloehen", "gignlngclmh", "b", "ll",
				"dokgngnocde", "cienegffibgieba", "agbachloidg", "mlelnafokd",
				"nmcmka", "akeogjbjcnf", "nebdic", "a", "efc", "ljdk", "jhcag",
				"bkbikbjgae", "mcjlgjeo", "lo", "dbiofobl", "cehebiljff",
				"eeagngm", "ondahcjiel", "coblanndhlhoggj", "jaobmjml",
				"jfejjinofek", "hhnna", "gdhcn", "acelcomgkgohm", "njkkjkkln",
				"jmc", "hkekoho", "boefec", "cioibfgjmhb", "ebggdbeimn",
				"emhg", "cfghkhii", "d", "k", "khoddedia", "nhje", "eebkfml",
				"bohhd", "kg", "n", "ilgemokdehcbaif", "cldicda", "einij",
				"akmabcgfn", "fmkmcn", "bnlfbagkke", "oakbgjejmcncj",
				"iehdfadgoik", "kkcfo", "jmjkmfcacjjnd", "ndokhh",
				"hjfeelhckkjjmj", "dnomohejbodkb", "jcmblncjadno",
				"oiofcodobiml", "ddmillkncjfdfj", "aihenmkdnhdhkhf",
				"bfdbakeilfdojnc", "jjhbkbne", "aigabk", "cae", "oednojjb",
				"gdoe", "jokjceohkmbm", "offkanbahigo", "kfomigbfddjli",
				"dkkjobgkcejei", "mdilld", "bofkika", "kkinig",
				"cljcflbghjmhmke", "kmbjlgdcbdjn", "bkgbmoahda",
				"kmnajjdemggnfg", "mgjndldil", "iemb", "kehaokgjg", "icign",
				"oijmaolehmoo", "amhgldifmgekhe", "diacnollhi", "lnjhdaafadl",
				"bdfiackhogoje", "ebjlfa", "deabkgfhnead", "gadcob", "haa",
				"dbhnbhjcmmab", "bbmjainilbbej", "dc", "bgjgafnjjflne",
				"ehholgnn", "fmhccbnc", "mdnfl", "feeejdgc", "mfhlobdadooh",
				"ojna", "gkgjnijdbgo", "ghngnhn", "nhnjaiaadiedgg", "nk",
				"hmd", "nmbmijaffogl", "onkcgbgmago", "gfli", "ofjlec",
				"nlfnbkkdc", "hakilani", "bofjdjkhllb", "ocjncleljnecfc",
				"gdonnkodmkejhf", "fiflchanfllgnf", "kaejakoibgln",
				"hmdlfioacgaci", "honmfbcog", "mlacbi", "gf", "ejbbemoeha",
				"acfjegee", "lllflaocnnkeadi", "mdgoebfgacecmbg", "faejgln",
				"kmlmhffgcmekm", "akcjmgdg", "kmhhh", "fdohjehacdln", "e",
				"ojba", "ohadmod", "eaenkdiaokl", "dii", "cgfjaklblafeifo",
				"imoeflkcgbbem", "nbjkmb", "jjgm", "hofgelg",
				"cnihecmdigdgflg", "fnmikkeldjgb", "onlhgonldjaedh", "fmkdn",
				"kfbcbleen", "oejioibnmab", "cg", "meadghbocjnj",
				"hmmdnkegfeieijn", "ijgenomhndlje", "maccdcgfjig", "iabemie",
				"mlfg", "mdblmdaechmeaml", "dhlafgjo", "eabbiila", "kf",
				"oehggehfmijlfmg", "klljaejidfhbon", "akmbgmignoag",
				"jgbkngmigdfm", "kjeelnbn", "ajaa", "mlcjoiaahoiga",
				"oalnielba", "ffmobgkc", "kmhoknfffdmo", "nagjiffnjhh",
				"dlehllomjok", "agaejefhdbk", "nnegoijfdj", "ndl",
				"dhfginocgi", "nflmglgh", "bcd", "gbgjijemmdio", "jk",
				"gidgjbmb", "hi", "lmgoah", "fdebefcech", "ach", "bahaoj",
				"ccmmblgibgjahi", "moid", "jhilgedidndm", "ldiakemnj",
				"bbnibccm", "jkbneoaheaajnm", "clkgmbjlgdnl", "lobbdldifnnijh",
				"dnmih", "jglia", "didicmghfe", "dlhbcfclf", "akbmioocoihkfh",
				"foofdldm", "imenimfcame", "ifekbmgnbdkc", "jjlkaabdollola",
				"gie", "hbaj", "noomfnfccmgaa", "dcjffeg", "nb", "obdb",
				"lolgjflimkib", "eaiigminlakkb", "cia", "hkf", "jknfklaio",
				"igklbiomo", "jfjgh", "ekgnkfnhjcch", "kmonfcclieehlik",
				"oggkmccklnmj", "bedhobcl", "egmnhajcnhcdgb", "imfdhekamfel",
				"bmmkhfdbm", "gnjfbcjlecfn", "llmkgclm", "gafinbnhfe",
				"mlbfedkoeeddfao", "kklcdmglleb", "ckekmeiea", "mi", "kfejn",
				"lm", "mk", "abkoajocfdili", "jidac", "jonhkanccl",
				"lllodjgnmm", "abfeaodlmjkngol", "cdncnh", "lkcb",
				"abhilnmmhijab", "hiljkfakojjld", "mbboobkaolkljo",
				"jhkblobaofgoh", "ncm", "mgbdhmcicomf", "oag", "akmjdd",
				"abkenodnhj", "mljf", "afb", "afejkobmiffeee", "oollnkilabmb",
				"gfaocokmcmjlmb", "cokmecdd", "bo", "endocdnmjiek", "bcf",
				"lhllbagiel", "bhihgofhj", "ffce", "neio", "ofbfiiab", "kjdo",
				"lgfggnamceeo", "kofledoinamcj", "femhndomndoakoa",
				"fmodaigcka", "omakggcalhn", "hhhogmcbjnhelkk", "mgah",
				"jghjjfmk", "ecolelfmcb", "eajjkdncafhhgab", "obno",
				"fifigfeok", "laafjimienff", "beckbbmhmofb", "nafhihmgnikd",
				"cbcfnhlkne", "kao", "nlkfhbm", "fmh", "ohfek", "oj",
				"hifgcgi", "adhkn", "lffgmodeafnn", "ngchmhdbmhmhh",
				"mcffimhnlffab", "blhmkdhbnhbb", "kkb", "lgkine",
				"hgfbdbfffanhik", "joebhbh", "img", "kglcddmloo", "hoflgfao",
				"bdhgdekb", "mggflahnoo", "cmnol", "imnmmgimmedf",
				"mcjmoofomiia", "mlakhbjfnbmgena", "ilhmcnkkeg", "domhbmkcd",
				"fco", "fdio", "cmkoagblnd", "kmihfigmceiiicm", "afgbadbgbaon",
				"menahlemehifooe", "jacokdiiokaic", "limj", "fkedaoomokjbkdi",
				"jkncd", "jblmcmfnegnk", "jjicjhjhbg", "gbfcead", "jf",
				"aifnkmnao", "effmhlhchngknl", "odhjeib", "ohcgmgb", "bgbd",
				"am", "kkjfbdlh", "hgbjakkokjgooel", "jbeokiakf", "flaoba",
				"cifcdnanmk", "mice", "ihhofdai", "ldnfmeiemhf",
				"kefbbohhgineacj", "bi", "njfie", "ociodahlomoekkf",
				"andhoindeca", "ajnndjocjeg", "bmijkmjbbkgbbh", "feanh",
				"bjemcefkfcaenal", "edfdenghinm", "moal", "ndbjdmijh",
				"enccnhmoifa", "dbckadjibam", "gd", "oglj", "aldjelhbemle",
				"cmbkofkcoe", "ihciacibeh", "lcojkclhmibgoif", "jfmjncnolfj",
				"gfcmcabhjki", "aggfmakaanjb", "mhbelld", "hon",
				"nkfoikcddehcah", "kggbigknacmohb", "jbkgndofcmaaohh",
				"gkjano", "afhhhh", "mjng", "jilckm", "dekkedjehmenbm", "clfm",
				"acmhbkdadgena", "oenokachg", "lhiea", "dceiag", "eebgj",
				"oolifidh", "dj", "cdfn", "eghdglgiok", "jdhegkefhbdhkm",
				"mhgngafea", "akabbcjkdnbc", "gcbn", "kimdgahf", "oc" });
		list = new WordBreakII().wordBreak("fajbeokiakfmlacbinjdnjdmmfha",
				set);
		PrintUtil.printList(list);
		long point3 = System.currentTimeMillis();
		System.out.println(point3 - point2);

		set.clear();
		Collections.addAll(set, new String[] { "aaaa", "aa", "a" });
		list = new WordBreakII().wordBreak("aaaaaaa", set);
		PrintUtil.printList(list);
		long point4 = System.currentTimeMillis();
		System.out.println(point4 - point3);
	}
}
