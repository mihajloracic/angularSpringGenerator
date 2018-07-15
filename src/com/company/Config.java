package com.company;

public class Config {
    public static final String RootPath = "C:\\Users\\mihajlo\\Desktop\\springmes";
    public static final String HTMLPagePath = RootPath+"\\src\\main\\resources\\static";
    public static final String RepositoryPath = RootPath+"\\src\\main\\java\\limes\\soft\\repository";
    public static final String ControllerPath = RootPath+"\\src\\main\\java\\limes\\soft\\controller";
    public static final String Package = "limes.soft.";
    public static String ExampleSelect = "select u.BrUgovora,u.SifKomint,k.NazivKomint,k.Mesto,u.Datum,u.DatumRok,u.RokUgovora,\n" +
            "u.TipDokumenta,u.RbrTendera,\n" +
            "u.VrstaObezbedjenja,u.RokValjanosti,u.VrObezbedjenja as VrednostObezbedjenja,\n" +
            "u.Valuta,u.NapomenaVal,u.VrstaUgovRobe,\n" +
            "isnull(u.VpVrUgovora,0) as VpVrednostUgovora,isnull(u.UkVrUgovora,0) as UkupnaVrednostUgovora,\n" +
            "DelovodiBrojKomitenta,DatumDelovodnogBrojaK,DelovodiBrojNas,DatumDelovodnogBrojaN,\n" +
            "(select uu.status\n" +
            "from ugovori uu\n" +
            "where uu.BrUgovora=u.BrUgovora) status,\n" +
            "(\n" +
            "(select isnull(convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  FaktureUgovoriOLD f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            ")\n" +
            "+\n" +
            " (select isnull(convert(money,sum(ff.Osnovica)),0)\n" +
            "     from  FakturaIzzagUsl ff\n" +
            "  where ff.RBrUgovora=u.brUgovora\n" +
            "and (ff.storno is null or ff.storno=0))\n" +
            " +\n" +
            " ( select isnull(convert(money,sum(ft.VpVrednostRacun)),0)\n" +
            "     from  TranzitniKalkRacun ft\n" +
            "  where ft.BrUgovoraK=u.brUgovora\n" +
            "and (ft.storno is null or ft.storno=0))\n" +
            "+\n" +
            " (select  isnull( convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  FakturaIzzag f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "and (f.storno is null or f.storno=0))\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  KnjizniListRobni f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "and (f.storno is null or f.storno=0))\n" +
            ")RacuniVpVrednost,\n" +
            "(\n" +
            "isnull(u.VpVrUgovora,0)\n" +
            "-\n" +
            "(\n" +
            "(select isnull(convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  FaktureUgovoriOLD f\n" +
            "  where f.BrUgovora=u.brUgovora)\n" +
            "+\n" +
            " (select isnull(convert(money,sum(ff.Osnovica)),0)\n" +
            "     from  FakturaIzzagUsl ff\n" +
            "  where ff.RBrUgovora=u.brUgovora\n" +
            "and (ff.storno is null or ff.storno=0))\n" +
            " +\n" +
            " ( select isnull(convert(money,sum(ft.VpVrednostRacun)),0)\n" +
            "     from  TranzitniKalkRacun ft\n" +
            "  where ft.BrUgovoraK=u.brUgovora\n" +
            "and (ft.storno is null or ft.storno=0))\n" +
            "+\n" +
            " (select  isnull( convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  FakturaIzzag f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "and (f.storno is null or f.storno=0))\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  KnjizniListRobni f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "and (f.storno is null or f.storno=0))\n" +
            ")\n" +
            ")RazlikaVpVrednost,\n" +
            "\n" +
            "(\n" +
            "(select isnull( convert(money,sum(f.IznosKupac)),0)\n" +
            "     from  FaktureUgovoriOLD f\n" +
            "  where f.BrUgovora=u.brUgovora)\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(ff.IznosKupac)),0)\n" +
            "     from  FakturaIzzagUsl ff\n" +
            "  where ff.RBrUgovora=u.brUgovora\n" +
            "  and (ff.storno is null or ff.storno=0))\n" +
            " +\n" +
            " ( select isnull( convert(money,sum(ft.IznosZaUplatu)),0)\n" +
            "     from  TranzitniKalkRacun ft\n" +
            "  where ft.BrUgovoraK=u.brUgovora\n" +
            "  and (ft.storno is null or ft.storno=0))\n" +
            "+\n" +
            " (select isnull( convert(money,sum(f.IznosKupac)),0)\n" +
            "     from  FakturaIzzag f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "  and (f.storno is null or f.storno=0))\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(f.IznosDokumenta)),0)\n" +
            "     from  KnjizniListRobni f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "  and (f.storno is null or f.storno=0))\n" +
            ")RacuniUkupnaVrednost,\n" +
            "(\n" +
            "isnull(u.UkVrUgovora,0)\n" +
            "-\n" +
            "(\n" +
            "(select isnull( convert(money,sum(f.IznosKupac)),0)\n" +
            "     from  FaktureUgovoriOLD f\n" +
            "  where f.BrUgovora=u.brUgovora)\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(ff.IznosKupac)),0)\n" +
            "     from  FakturaIzzagUsl ff\n" +
            "  where ff.RBrUgovora=u.brUgovora\n" +
            "  and (ff.storno is null or ff.storno=0))\n" +
            " +\n" +
            " ( select isnull( convert(money,sum(ft.IznosZaUplatu)),0)\n" +
            "     from  TranzitniKalkRacun ft\n" +
            "  where ft.BrUgovoraK=u.brUgovora\n" +
            "  and (ft.storno is null or ft.storno=0))\n" +
            "+\n" +
            " (select isnull( convert(money,sum(f.IznosKupac)),0)\n" +
            "     from  FakturaIzzag f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "  and (f.storno is null or f.storno=0))\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(f.IznosDokumenta)),0)\n" +
            "     from  KnjizniListRobni f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "  and (f.storno is null or f.storno=0))\n" +
            ")\n" +
            "\n" +
            ")RazlikaUkupnaVrednost,\n" +
            "\n" +
            "(select isnull(sum(i.JosOstalo * i.Cena),0)\n" +
            "    from IzjavaKupcaSta i , IzjavaKupcaZag iz\n" +
            "    where i.RbrIzjave=iz.RbrIzjave\n" +
            "          and i.JosOstalo>0\n" +
            "          and iz.BrUgovora=u.BrUgovora)OstaloZaRealizacijuIzjave,\n" +
            "(select isnull(sum(i.JosOstalo * i.Cena),0)\n" +
            "    from GeneralnaIzjavaSta i , GeneralnaIzjavaZag iz\n" +
            "    where i.RbrIzjave=iz.RbrIzjave\n" +
            "          and i.JosOstalo>0\n" +
            "          and iz.BrUgovora=u.BrUgovora)OstaloZaRealizacijuGodIzjave,\n" +
            "(select isnull(sum(i.JosOstalo * i.Cena),0)\n" +
            "    from PredracunSta i , PredracunZag iz\n" +
            "    where i.RbrPredracuna=iz.RbrPredracuna\n" +
            "          and i.JosOstalo>0\n" +
            "          and iz.BrUgovora=u.BrUgovora)OstaloZaRealizacijuPredracuna,\n" +
            "-- RazlikaVpVrednost-OstaloZaRealizacijuIzjave-OstaloZaRealizacijuGodIzjave-OstaloZaRealizacijuPredracuna\n" +
            "((\n" +
            "isnull(u.VpVrUgovora,0)\n" +
            "-\n" +
            "(\n" +
            "(select isnull(convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  FaktureUgovoriOLD f\n" +
            "  where f.BrUgovora=u.brUgovora)\n" +
            "+\n" +
            " (select isnull(convert(money,sum(ff.Osnovica)),0)\n" +
            "     from  FakturaIzzagUsl ff\n" +
            "  where ff.RBrUgovora=u.brUgovora\n" +
            "and (ff.storno is null or ff.storno=0))\n" +
            " +\n" +
            " ( select isnull(convert(money,sum(ft.VpVrednostRacun)),0)\n" +
            "     from  TranzitniKalkRacun ft\n" +
            "  where ft.BrUgovoraK=u.brUgovora\n" +
            "and (ft.storno is null or ft.storno=0))\n" +
            "+\n" +
            " (select  isnull( convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  FakturaIzzag f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "and (f.storno is null or f.storno=0))\n" +
            "+\n" +
            "(select  isnull( convert(money,sum(f.IznosRobe)),0)\n" +
            "     from  KnjizniListRobni f\n" +
            "  where f.BrUgovora=u.brUgovora\n" +
            "and (f.storno is null or f.storno=0))\n" +
            ")\n" +
            "\n" +
            "-\n" +
            "(select isnull(sum(i.JosOstalo * i.Cena),0)\n" +
            "    from IzjavaKupcaSta i , IzjavaKupcaZag iz\n" +
            "    where i.RbrIzjave=iz.RbrIzjave\n" +
            "          and i.JosOstalo>0\n" +
            "          and iz.BrUgovora=u.BrUgovora)\n" +
            "-\n" +
            "(select isnull(sum(i.JosOstalo * i.Cena),0)\n" +
            "    from GeneralnaIzjavaSta i , GeneralnaIzjavaZag iz\n" +
            "    where i.RbrIzjave=iz.RbrIzjave\n" +
            "          and i.JosOstalo>0\n" +
            "          and iz.BrUgovora=u.BrUgovora)\n" +
            "-\n" +
            "(select isnull(sum(i.JosOstalo * i.Cena),0)\n" +
            "    from PredracunSta i , PredracunZag iz\n" +
            "    where i.RbrPredracuna=iz.RbrPredracuna\n" +
            "          and i.JosOstalo>0\n" +
            "          and iz.BrUgovora=u.BrUgovora)\n" +
            "\n" +
            "))KontrolaRealizacije,\n" +
            "(\n" +
            "(select isnull(convert(money,sum(f.Osnovica)),0)\n" +
            "     from  FakturaUlZagOld f\n" +
            "  where (f.BrUgovora=u.brUgovora or f.BrUgovora2=u.brUgovora ) and f.storno=0\n" +
            ")\n" +
            "+\n" +
            " (select isnull(convert(money,sum(ff.Osnovica)),0)\n" +
            "     from  FakturaUlZag ff\n" +
            "  where (ff.BrUgovora=u.brUgovora or ff.BrUgovora2=u.brUgovora) \n" +
            "and (ff.storno is null or ff.storno=0))\n" +
            ") as UlazniRnVrBezPDV,\n" +
            "\n" +
            "(\n" +
            "(select isnull(convert(money,sum(f.VrednostZaUplatu)),0)\n" +
            "     from  FakturaUlZagOld f\n" +
            "  where (f.BrUgovora=u.brUgovora or f.BrUgovora2=u.brUgovora ) and f.storno=0\n" +
            ")\n" +
            "+\n" +
            " (select isnull(convert(money,sum(ff.VrednostZaUplatu)),0)\n" +
            "     from  FakturaUlZag ff\n" +
            "  where (ff.BrUgovora=u.brUgovora or ff.BrUgovora2=u.brUgovora) \n" +
            "and (ff.storno is null or ff.storno=0))\n" +
            ") as UlazniRnUkupno,\n" +
            "\n" +
            "pon.Referent as PonReferent,pr.Ime as ImePonReferent,\n" +
            " ten.referent as TenReferent,tr.Ime as ImeTenReferent,\n" +
            "u.RbrPonude,pon.BrojPonude,pon.Datum as datumPonude,\n" +
            "(select k.Supervizor \n" +
            "  from Komintenti k \n" +
            "where k.SifKomint=u.SifKomint) as Supervizor,\n" +
            "(select rrk.Ime \n" +
            "  from Komintenti k\n" +
            "  left outer join Referenti rrk\n" +
            "  on K.Supervizor=rrk.SifRadnika\n" +
            "  where k.SifKomint=u.SifKomint\n" +
            ") as ImeSupervizora\n" +
            "\n" +
            " from V_Komintenti_ptt k, Ugovori u\n" +
            "  left outer join Tenderi ten\n" +
            "     on u.RbrTendera=ten.RbrTendera\n" +
            "  left outer join PonudaZag pon\n" +
            "    on u.RbrPonude=pon.RbrPonude\n" +
            "  left outer join Referenti pr\n" +
            "    on pon.Referent=pr.SifRadnika\n" +
            "  left outer join Referenti tr\n" +
            "    on ten.Referent=tr.SifRadnika\n" +
            "where  u.SifKomint=k.SifKomint\n" +
            "order by u.BrUgovora";
}
