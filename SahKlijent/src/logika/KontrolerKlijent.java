 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logika;

import domen.Igrac;
import domen.Klub;
import domen.Kolo;
import domen.Partija;
import domen.Prijava;
import domen.Sudija;
import domen.Turnir;
import forme.DodajIgraca;
import forme.DodajTurnir;
import forme.FormaGlavna;

        import java.util.LinkedList;
import forme.FormaLogin;
import forme.FormaPlasman;
import forme.GotovTurnir;
import forme.IzmenaTurnira;
import forme.PretragaIgraca;
import forme.PretragaKlubova;
import forme.PretragaTurnira;
import forme.Sudijina;
import forme.UnosRezultataPartije;
import java.io.IOException;
import javax.security.auth.callback.ConfirmationCallback;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import komunikacija.Komunikacija;
import konstante.Operacije;
import model.TabelaPartije;
import sesija.Sesija;
import transfer.KlijentskiZahtev;

/**
 *
 * @author Milena Kutch
 */
public class KontrolerKlijent {
    private FormaLogin frmlogin;
    private FormaGlavna frmglavna;
    private PretragaKlubova pretragaklubova;
    private PretragaIgraca pretragaigraca;
    private PretragaTurnira pretragaturnira;
    private DodajIgraca dodajIgraca;
    private FormaPlasman plasman;
    private LinkedList<Klub> listaKlubova;
    private LinkedList<Igrac> listaIgraca;
    private IzmenaTurnira turnirinovi;
    private UnosRezultataPartije unosrez;
    private Sudijina frmsudijina;
    private DodajTurnir dodajturnir;

    public KontrolerKlijent() {
    }
      
    
    private static KontrolerKlijent instance;

   

    public static KontrolerKlijent getInstance() {
        if(instance == null){
            instance = new KontrolerKlijent();
        }
        return instance;
    }

    public FormaLogin getFrmlogin() {
        return frmlogin;
    }

    public void setFrmlogin(FormaLogin frmlogin) {
        this.frmlogin = frmlogin;
    }

    public FormaGlavna getFrmglavna() {
        return frmglavna;
    }

    public void setFrmglavna(FormaGlavna frmglavna) {
        this.frmglavna = frmglavna;
    }
    
    public void ulogujSudiju(Sudija sudija){
        Sesija.getInstance().setUlogovani(sudija);
        
        JOptionPane.showMessageDialog(frmlogin, "Sluzbenik je uspesno prijavljen","Uspesno prijavljivanje!", JOptionPane.INFORMATION_MESSAGE);
        frmsudijina = new Sudijina();
        frmsudijina.postaviSudiju(sudija);
        
        
        frmsudijina.setVisible(true);
        frmsudijina.setLocationRelativeTo(null);
        frmlogin.setVisible(false);
        
    }

    public DodajIgraca getDodajIgraca() {
        return dodajIgraca;
    }

    public void setDodajIgraca(DodajIgraca dodajIgraca) {
        this.dodajIgraca = dodajIgraca;
    }
    
    
    public void greskaPriLogovanju (String poruka){
        poruka = "Netacno korisnicko ime ili lozinka!";
         JOptionPane.showMessageDialog(frmlogin, poruka, "Greska u prijavljivanju!", JOptionPane.ERROR_MESSAGE);
        frmlogin.getBtnLogin().setEnabled(true);   
    }

    public LinkedList<Klub> getListaKlubova() {
        return listaKlubova;
    }
    

    public void ucitajKlubove(LinkedList<Klub> klubovi) {
        listaKlubova = klubovi;
        pretragaklubova.popuniTabelu(klubovi);
    }

    public void greskaKodKlubova(String greska) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PretragaKlubova getPretragaklubova() {
        return pretragaklubova;
    }

    public void setPretragaklubova(PretragaKlubova pretragaklubova) {
        this.pretragaklubova = pretragaklubova;
    }

    public PretragaIgraca getPretragaigraca() {
        return pretragaigraca;
    }

    public void setPretragaigraca(PretragaIgraca pretragaigraca) {
        this.pretragaigraca = pretragaigraca;
    }

    public void ucitajIgrace(LinkedList<Igrac> igraci) {
        listaIgraca=igraci;
        Sesija.getInstance().setIgraciLista(igraci);
       // pretragaigraca.setCuvamListu(igraci);
       // pretragaigraca.popuniTabelu(igraci);
       //frmglavna.setIGRACI(igraci);
    }

    public void greskaKodIgraca(String greska) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public PretragaTurnira getPretragaturnira() {
        return pretragaturnira;
    }

    public void setPretragaturnira(PretragaTurnira pretragaturnira) {
        this.pretragaturnira = pretragaturnira;
    }

    public void ucitajTurnire(LinkedList<Turnir> turniri) {
        if (pretragaturnira==null){
            System.out.println("medo");
        } else       pretragaturnira.popuniTabelu(turniri);
       frmsudijina.popuniTabelu(turniri);
    }

    public void greskaKodTurnira(String greska) {
        JOptionPane.showMessageDialog(pretragaturnira, "Nepravilan unos kriterijuma!",greska, JOptionPane.ERROR_MESSAGE);
    }

    public void dodajIgraca(String status) {
         JOptionPane.showMessageDialog(dodajIgraca, status, "Status",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void dodavanjeIgracaGreska(String greska) {
        JOptionPane.showMessageDialog(dodajIgraca, "Ne mozete dodati igraca, vec postoji u bazi!", greska, JOptionPane.ERROR_MESSAGE);
    }

    public PretragaKlubova posaljiPK() {
        if (pretragaklubova==null){
            System.out.println("medo");
        }
        return pretragaklubova;
    }

    public void izlogujSudiju(boolean uspesno) {
        if (frmsudijina != null) {
            odjava(uspesno);
            frmsudijina.dispose();
           
        }
        frmlogin.setVisible(true);
        frmlogin.setBtnLoginEnabled();
        System.out.println("sudija odjavljen!");
        Sesija.getInstance().setUlogovani(null);
    }
    public void odjava(boolean uspesno) {
        String message;
        if (uspesno) {     //true ako je klijent trazio
            message = "Uspesno ste se odjavili!";
        } else {              //false ako je server iskljucen
            message = "Veza sa serverom je prekinuta!";
        }
        JOptionPane.showMessageDialog(frmglavna, message);
    }
    public LinkedList<Igrac> getListaIgraca() {
        return listaIgraca;
    }

    public void setListaIgraca(LinkedList<Igrac> listaIgraca) {
        this.listaIgraca = listaIgraca;
    }

    public void ucitajIgrace2(LinkedList<Igrac> igraci2) {
        
        frmglavna.setIGRACI(igraci2);
        
    }

    public void setListaKlubova(LinkedList<Klub> listaKlubova) {
        this.listaKlubova = listaKlubova;
    }

    public void cuvanjeKolaGreska(String greska) {
        JOptionPane.showMessageDialog(frmglavna, "Kolo ne moze da se sacuva, proverite unos rezultata.", greska, JOptionPane.ERROR_MESSAGE);
    }

    public void sacuvajKolo(String status) {
        JOptionPane.showMessageDialog(frmglavna, status, "Status",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void ucitajPartije(LinkedList<Partija> partije) {
         
      parovanje(partije);
      
      
    }

    public void greskaKodPartija(String greska) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void osveziTabeluTurnira(LinkedList<Turnir> tu) {
        pretragaturnira.popuniTabelu(tu);
        
    }

    public FormaPlasman getPlasman() {
        return plasman;
    }

    public void setPlasman(FormaPlasman plasman) {
        this.plasman = plasman;
    }

    //public void staviPlasman(LinkedList<Igrac> rez) {
   //     plasman.popuniTabelu(rez);
   // }

    public void osveziTabeluKlubova(LinkedList<Klub> kl) {
        pretragaklubova.popuniTabelu(kl);
    }

    public void igracObrisan(String status) {
      if (status.equals("Turnir je uspešno obrisan!")){
          JOptionPane.showMessageDialog(frmglavna, "Turnir je uspesno obrisan iz baze!");
      } else   JOptionPane.showMessageDialog(frmglavna, "doslo je do greske. Turnir nije obrisan iz baze");
    }

    public void zatraziKlubove(LinkedList<Klub> kluli) {
        popuniKlubove(kluli);
        
    }

    public void uzmiKlubove(LinkedList<Klub> klulil) {
        pretragaigraca.popuniKlubove(klulil);
    }

    public void osveziTabeluIgraca(LinkedList<Igrac> tu) {
        pretragaigraca.popuniTabelu(tu);
    }

    public void izmeniTurnir(String status1) {
       if (status1.equals("Podaci o turniru su izmenjeni")){
          JOptionPane.showMessageDialog(frmsudijina, "Podaci o turniru su uspesno izmenjeni!");
      } else   JOptionPane.showMessageDialog(frmsudijina, "doslo je do greske. Podaci o turniru nisu izmenjeni u bazi.");
    }

    public void popuniIgrace()  {
         
            KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_IGRACE);
        
            Komunikacija.getInstance().posaljiZahtev(kz);
    }
       public  void odjaviSe() {
        Sudija s = Sesija.getInstance().getUlogovani();
        KlijentskiZahtev kz = new KlijentskiZahtev(Operacije.IZLOGUJ_SE, s);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
        
    }
       
          public void srediPanel(LinkedList<Igrac> ucesnici) {
        
        int tabla = 1;
        Kolo k = new Kolo();
        k.setId(frmglavna.getAktivno());
        frmglavna.getLblOdigrano().setText(frmglavna.getOdigrano()+"");
        frmglavna.getLblAktivno().setText(frmglavna.getAktivno()+"");
        TabelaPartije tp = new TabelaPartije();
        frmglavna.getTblPartije().setModel(tp);
        LinkedList<Partija> partije = new LinkedList<>();
    //    LinkedList<Igrac> igraci = IGRACI;
        int rb=1;
        LinkedList<Igrac> vecIsparovani= new LinkedList<>();
        if (ucesnici == null){
            System.out.println("medo");
        } else{
            if (ucesnici.size()%2==1){
            ucesnici.add(new Igrac(0, "nesparen", "", "", 0, new Klub()));
            }
       for (Igrac igrac : ucesnici) {
                for (Igrac igrac1 : ucesnici) {
               if (igrac==igrac1){
                  
                   continue;
               }
              if (!vecIsparovani.contains(igrac) && !vecIsparovani.contains(igrac1)){
                  Partija p = new Partija(rb++, tabla++,Sesija.getInstance().getUlogovani(), igrac, igrac1, k,Sesija.getInstance().getTurnir(),0,1);
                  
                  
                  partije.add(p);
                  vecIsparovani.add(p.getBeli());
                  vecIsparovani.add(p.getCrni());
                  
                  p.getBeli().getProtivnici().add(p.getCrni());
                  p.getCrni().getProtivnici().add(p.getBeli());
                 // dodajpoeneigracima(partije);
              } 
       } 
       }
                tp.postaviListu(partije);
                
    }
    }
    
             public void parovanje(LinkedList<Partija> partije) {
    
         int tabla = 1;
        Kolo k = new Kolo();
        k.setId(frmglavna.getAktivno());
        TabelaPartije tp = new TabelaPartije();
        frmglavna.getTblPartije().setModel(tp);
        LinkedList<Partija> partijeOvoKolo = new LinkedList<>();
        LinkedList<Igrac> vecIsparovani= new LinkedList<>();
        
        int dosadapartija = partije.size()+1;
         if (frmglavna.getIGRACI() == null){
                        System.out.println("medo");
                   } 
         else{
            if (frmglavna.getIGRACI().size()%2==1){
                frmglavna.getIGRACI().add(new Igrac(0, "nesparen", "", "", 0, new Klub()));
        }
        for (Igrac ig1 : frmglavna.getIGRACI()) {
            for (Igrac ig2 : frmglavna.getIGRACI()) {
                
                     if (!vecIsparovani.contains(ig1) && !vecIsparovani.contains(ig2) && !nepostoji(ig1,ig2) && !ig1.equals(ig2)){
                  Partija p = new Partija(dosadapartija++, tabla++,Sesija.getInstance().getUlogovani(), ig1, ig2, k,Sesija.getInstance().getTurnir() , 1, 0);
                  
                      
                  partijeOvoKolo.add(p);
                  vecIsparovani.add(p.getBeli());
                  vecIsparovani.add(p.getCrni());
                  
                  p.getBeli().getProtivnici().add(p.getCrni());
                  p.getCrni().getProtivnici().add(p.getBeli());
                       
                  
              }    
                
            }
            
        }   tp.postaviListu(partijeOvoKolo);
    }
    }
   

    public void uzmiPartije()  {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_PARTIJE);
            Komunikacija.getInstance().posaljiZahtev(kz);
    }

    public void izBazePartije(LinkedList<Partija> partije) {
         parovanje(partije);
        
    }

    public boolean nepostoji(Igrac ig1, Igrac ig2) {
                   if (ig1.getProtivnici().contains(ig2) || ig2.getProtivnici().contains(ig1)){
                       return true;
                   } else return false;
    }

    public void dodajpoeneigracima(LinkedList<Partija> partijeOvoKolo)  {
       
        
        for (Partija partija : partijeOvoKolo) {
            String pp=partija.getBodovibeli()+"";
            switch(pp){
                case "1.0":
                    double p = partija.getBeli().getPoeni();
                    
                partija.getBeli().setPoeni(++p);
                    break;
                    case"0.0":
                        double p1 = partija.getCrni().getPoeni();
                partija.getCrni().setPoeni(++p1);
                break;
                    case"0.5":
                         double p3 = partija.getBeli().getPoeni();
                         
                partija.getBeli().setPoeni(p3+0.5);
                double p2 = partija.getCrni().getPoeni();
                partija.getBeli().setPoeni(p2+0.5);
                break;
                   
            }
          //  if (partija.getBodovibeli()==1){
                //dodajese.add(partija.getBeli());
            //    double p = partija.getBeli().getPoeni();
             //   partija.getBeli().setPoeni(++p);
               
          //  } else if (partija.getBodovicrni()==1){
           //    dodajese.add(partija.getCrni());
            //   double p = partija.getCrni().getPoeni();
            //    partija.getCrni().setPoeni(++p);
           // } else if (partija.getBodovibeli()==0.5 && partija.getBodovicrni()==0.5){
               
               // dodajepola.add(partija.getBeli());
               //dodajepola.add(partija.getCrni());
               //double p = partija.getBeli().getPoeni();
               // partija.getBeli().setPoeni(p+0.5);
                //double p2 = partija.getCrni().getPoeni();
               // partija.getBeli().setPoeni(p2+0.5);
            }
        } 
        //izmeniIgrace(dodajese, dodajepola);
        
    

    public void izmeniIgrace(LinkedList<Igrac> dodajese, LinkedList<Igrac>dodajepola)  {
        
        // KlijentskiZahtev kz = new KlijentskiZahtev();
       // kz.setOperacija(Operacije.IZMENI_IGRACA);
        //kz.setParametar(dodajese);
           // Komunikacija.getInstance().posaljiZahtev(kz);
           for (Igrac igrac : dodajepola) {
               double p = igrac.getPoeni();
            igrac.setPoeni(p+0.5);
        }
           
           for (Igrac igrac : dodajese) {
            double p = igrac.getPoeni();
               System.out.println("igrac:"+igrac);
               System.out.println("POPO:"+p);
            igrac.setPoeni(++p);
            System.out.println("POPOPO:"+p);
        }
    }
    
    public void unos (){
        int odabrana = frmglavna.getTblPartije().getSelectedRow();
        TabelaPartije tp = (TabelaPartije) frmglavna.getTblPartije().getModel();
        Partija zaIzmenu = tp.getLista().get(odabrana);
        UnosRezultataPartije urp = new UnosRezultataPartije(frmglavna, true, zaIzmenu);
        urp.setVisible(true);
        urp.setLocationRelativeTo(null);
    }
    
    public void cuvanje() {
        int rand = (int)Math.round(Math.random()*10000);
        if (frmglavna.getOdigrano()==9){
            JOptionPane.showMessageDialog(frmglavna, "Maksimalan broj kola na turniru je 9 tako da je ovaj turnir zavrsen. "); 
             JOptionPane.showMessageDialog(frmglavna, "Program ce promeniti status turnira. Hvala na odlicnom sudjenju!");
                    Turnir gotov = Sesija.getInstance().getTurnir();
                     gotov.setStatus("zavrsen");
                      gotov.setBrojOdigranih(frmglavna.getOdigrano());
                      KlijentskiZahtev kz3 = new KlijentskiZahtev();
        kz3.setOperacija(Operacije.ZAPAMTI_PODATKE_O_TURNIRU);
        kz3.setParametar(gotov);
            Komunikacija.getInstance().posaljiZahtev(kz3);
            
                    GotovTurnir gt = new GotovTurnir(frmglavna, true, gotov);
                    gt.setVisible(true);
                    frmglavna.getBtnSacuvaj().setEnabled(false); frmglavna.getBtnUnesi().setEnabled(false);
                    frmglavna.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
        
        TabelaPartije tp = (TabelaPartije) frmglavna.getTblPartije().getModel();
      LinkedList<Partija> par = tp.getLista();
      LinkedList<Partija> zavrsene = new LinkedList<>();
      dodajpoeneigracima(par);
        for (Partija partija : par) {
            if((partija.getBodovibeli()==1 || partija.getBodovibeli()==0 || partija.getBodovibeli()==0.5) && (partija.getBodovicrni()==1 || partija.getBodovicrni()==0 || partija.getBodovicrni()==0.5)){
                zavrsene.add(partija);
            }
       
        }
        if (zavrsene.size()== par.size()){
            Kolo kolo= new Kolo(rand, Sesija.getInstance().getTurnir().getID(),frmglavna.getOdigrano(), par);
            
           
           
             KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.SACUVAJ_KOLO);
        kz.setParametar(kolo);
            Komunikacija.getInstance().posaljiZahtev(kz);
            int rezultat = JOptionPane.showConfirmDialog(frmglavna, "Da li zelite da kreirate sledece kolo?", "Potvrda", ConfirmationCallback.YES_NO_OPTION);
            if (rezultat==JOptionPane.YES_OPTION){
                frmglavna.setAktivno(frmglavna.getAktivno() + 1);
                frmglavna.setOdigrano(frmglavna.getOdigrano() + 1);
                frmglavna.getLblOdigrano().setText(frmglavna.getOdigrano()+"");
                frmglavna.getLblAktivno().setText(frmglavna.getAktivno()+"");
               
                KontrolerKlijent.getInstance().uzmiPartije();
                
            }
            if (rezultat == JOptionPane.NO_OPTION){
                int rezultat2=JOptionPane.showConfirmDialog(frmglavna, "Da li je turnir zavrsen?", "Potvrda", ConfirmationCallback.YES_NO_OPTION);
                if (rezultat2==JOptionPane.YES_OPTION){
                     JOptionPane.showMessageDialog(frmglavna, "Program ce promeniti status turnira. Hvala na odlicnom sudjenju!");
                    Turnir gotov = Sesija.getInstance().getTurnir();
                     gotov.setStatus("zavrsen");
                     gotov.setBrojOdigranih(frmglavna.getOdigrano());
                      KlijentskiZahtev kz2 = new KlijentskiZahtev();
        kz2.setOperacija(Operacije.ZAPAMTI_PODATKE_O_TURNIRU);
        kz2.setParametar(gotov);
            Komunikacija.getInstance().posaljiZahtev(kz2);
                    GotovTurnir gt = new GotovTurnir(frmglavna, true, gotov);
                    gt.setVisible(true);
                    frmglavna.getBtnSacuvaj().setEnabled(false); frmglavna.getBtnUnesi().setEnabled(false);
                    frmglavna.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                   
                   // KlijentskiZahtev kz2 = new KlijentskiZahtev();
       // kz2.setOperacija(Operacije.OBRISI_TURNIR);
       // kz2.setParametar(gotov);
           // Komunikacija.getInstance().posaljiZahtev(kz2);
                } else JOptionPane.showMessageDialog(frmglavna, "Ne mozete zavrsiti sesiju ili poceti novi turnir pre nego sto se turnir zavrsi. nastavite sa uspesnim sudjenjem. srecno!");
            }
            
        } else JOptionPane.showMessageDialog(frmglavna, "niste uneli rezultat za sve partije.");
    }
    
        public void popuniKlubove(LinkedList<Klub> kluli) {
   
    dodajIgraca.getCmbKlub().removeAllItems();
        for (Klub klub : kluli) {
            dodajIgraca.getCmbKlub().addItem(klub);
        }
        
    }

    public void zatraziKlubove()  {
        
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZATRAZI_KLUBOVE);
       
            Komunikacija.getInstance().posaljiZahtev(kz);
    }
    
     public void kreiranjeIgraca() {
         if (dodajIgraca.getTxtIme().getText().isEmpty() || dodajIgraca.getTxtPrezime().getText().isEmpty() ){
             JOptionPane.showMessageDialog(dodajIgraca, "morate popuniti sva polja!");
             return;
         }
           String ime = dodajIgraca.getTxtIme().getText();
        String prezime = dodajIgraca.getTxtPrezime().getText();
        Klub klub = (Klub) dodajIgraca.getCmbKlub().getSelectedItem();
        String kategorija = (String) dodajIgraca.getCmbKategorija().getSelectedItem();
        int rejting  = Integer.parseInt(dodajIgraca.getTxtRejting().getText());
        
        Igrac i = new Igrac(-1, ime, prezime, kategorija, rejting, klub);
     
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.KREIRAJ_IGRACA);
        kz.setParametar(i);
            Komunikacija.getInstance().posaljiZahtev(kz);
     }
     
     public void izmenaTurnira() {
           String mesto = turnirinovi.getTxtmesto().getText();
        String tip = (String) turnirinovi.getCmbtip().getSelectedItem();
        String tempo = (String) turnirinovi.getCmbtempo().getSelectedItem();
        String status = (String) turnirinovi.getTxtStatus().getSelectedItem();
        String region = (String) turnirinovi.getCmbRegion().getSelectedItem();
        if (turnirinovi.getTxtmesto().getText().isEmpty()){
            JOptionPane.showMessageDialog(turnirinovi, "morate uneti sve parametre"); return;
        }
        
        Turnir izmenjen = new Turnir(turnirinovi.getT().getID(),turnirinovi.getTxtnaziv().getText(), mesto, tip, tempo, new LinkedList<>(), null, Sesija.getInstance().getUlogovani(),status,region );
       
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.ZAPAMTI_PODATKE_O_TURNIRU);
        kz.setParametar(izmenjen);
            Komunikacija.getInstance().posaljiZahtev(kz);
     }
     


    public IzmenaTurnira getTurnirinovi() {
        return turnirinovi;
    }

    public void setTurnirinovi(IzmenaTurnira turnirinovi) {
        this.turnirinovi = turnirinovi;
    }

    public UnosRezultataPartije getUnosrez() {
        return unosrez;
    }

    public void setUnosrez(UnosRezultataPartije unosrez) {
        this.unosrez = unosrez;
    }
    
    public void trazenjeIgraci(){
              try {
            String kriterijum = uzmiKriterijumIgraci();
            
            
            if (kriterijum.equals("")) {
                osveziTabeluIgraca(listaIgraca);
            }else{
            KlijentskiZahtev kz = new KlijentskiZahtev();
            kz.setOperacija(Operacije.PRONADJI_IGRACE);
            kz.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(kz);}
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pretragaigraca, ex.getMessage(), "Greška",
                                                JOptionPane.ERROR_MESSAGE);
          
        }
    }
    
        public String uzmiKriterijumIgraci() {
       
        String kriterijum = "";

        if (!pretragaigraca.getBtnSve().isSelected()) {
            String kritIme = "";
            String kritVr = "";

            if (pretragaigraca.getBtnime().isSelected() && pretragaigraca.getTxtime().getText().isEmpty()){
                JOptionPane.showMessageDialog(pretragaigraca, "nije unet kriterijum pretragae"); 
            }
            if (pretragaigraca.getBtnprezime().isSelected() && pretragaigraca.getTxtprezime().getText().isEmpty()){
                JOptionPane.showMessageDialog(pretragaigraca, "nije unet kriterijum pretragae"); 
            }


                if (pretragaigraca.getBtnkat().isSelected()) {
                    kritIme = "kategorija";
                    kritVr = " LIKE '%" + pretragaigraca.getCmbkat().getSelectedItem() + "%'";
                    

                } else if (pretragaigraca.getBtnime().isSelected()) {
                    kritIme = "LOWER(ime)";
                    kritVr = " LIKE '%" + pretragaigraca.getTxtime().getText() + "%'";
                    

                } else if (pretragaigraca.getBtnklub().isSelected()) {
                    kritIme = "LOWER(k.naziv)";
                    kritVr = " LIKE '%" + pretragaigraca.getCmbKlub().getSelectedItem() + "%'";
                } else if (pretragaigraca.getBtnprezime().isSelected()) {
                    kritIme = "LOWER(prezime)";
                    kritVr = " LIKE '%" + pretragaigraca.getTxtprezime().getText() + "%'";
                } 
             
            kriterijum = kritIme + kritVr;
            System.out.println("EVE KRITERIJUMA:"+kriterijum);
        }
        return kriterijum;
    }
        
        public void trazenjeKlubovi(){
              try {
            String kriterijum = uzmiKriterijumKlubovi();
            if (!pretragaklubova.getBtnGrad().isSelected() && !pretragaklubova.getBtnNaziv().isSelected() && !pretragaklubova.getBtnSve().isSelected()){
                JOptionPane.showMessageDialog(pretragaklubova, "morate izabrati kriterijum pretrage"); return;
            }
            
            if (kriterijum.equals("")) {
                pretragaklubova.popuniKlubove();
            }else{
            KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRONADJI_KLUB);
       kz.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(kz);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pretragaklubova, ex.getMessage(), "Greška",
                                                JOptionPane.ERROR_MESSAGE);
          
        }
        }
        
           private String uzmiKriterijumKlubovi() {
         String kriterijum = "";

        if (!pretragaklubova.getBtnSve().isSelected()) {
            String kritIme = "";
            String kritVr = "";

                if (pretragaklubova.getBtnGrad().isSelected()) {
                    kritIme = "grad";
                    kritVr = " LIKE '%" + pretragaklubova.getTxtKrit().getText() + "%'";

                } else if (pretragaklubova.getBtnNaziv().isSelected()) {
                    kritIme = "LOWER(naziv)";
                    kritVr = " LIKE '%" + pretragaklubova.getTxtKrit().getText() + "%'";
                }
                

            kriterijum = kritIme + kritVr;
            System.out.println("EVE KRITERIJUMA:"+kriterijum);
        }
        return kriterijum;
    }
           
           public void trazenjeTurniri(){
                try {
          
            String kriterijum = uzmiKriterijumTurniri();
            
            
            if (kriterijum.equals("")) {
                pretragaturnira.popuniTurnire();
            }else{
            KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.PRONADJI_TURNIR);
        kz.setParametar(kriterijum);
            Komunikacija.getInstance().posaljiZahtev(kz);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(pretragaturnira, ex.getMessage(), "Greška",
                                                JOptionPane.ERROR_MESSAGE);
          
        }
           }

    public String uzmiKriterijumTurniri() {
                String kriterijum = "";

        if (!pretragaturnira.getBtnSve().isSelected()) {
            String kritIme = "";
            String kritVr = "";


                if (pretragaturnira.getBtntip().isSelected()) {
                    kritIme = "tip";
                    kritVr = " LIKE '%" + pretragaturnira.getCmbtip().getSelectedItem() + "%'";

                } else if (pretragaturnira.getBtnnaziv().isSelected()) {
                    kritIme = "LOWER(naziv)";
                    kritVr = " LIKE '%" + pretragaturnira.getTxtnaziv().getText() + "%'";
                    

                } else if (pretragaturnira.getBtntempo().isSelected()) {
                    kritIme = "LOWER(tempo)";
                    kritVr = " LIKE '%" + pretragaturnira.getCmbtempo().getSelectedItem() + "%'";
                }
                else if (pretragaturnira.getBtnregion().isSelected()) {
                    kritIme = "LOWER(region)";
                    kritVr = " LIKE '%" + pretragaturnira.getCmbregion().getSelectedItem() + "%'";
                }
                

            kriterijum = kritIme + kritVr;
            System.out.println("EVE KRITERIJUMA:"+kriterijum);
        }
        return kriterijum; 
    }

    public Sudijina getFrmsudijina() {
        return frmsudijina;
    }

    public void setFrmsudijina(Sudijina frmsudijina) {
        this.frmsudijina = frmsudijina;
    }

    public void uzmiPrijave(Turnir turnir) {
        KlijentskiZahtev kz = new KlijentskiZahtev();
        kz.setOperacija(Operacije.UCITAJ_PRIJAVE);
        String kriterijum = " TurnirID="+turnir.getID();
        System.out.println("kriterijum:"+kriterijum);
        kz.setParametar(kriterijum);
        Komunikacija.getInstance().posaljiZahtev(kz);
        
    }

    public void stiglePrijave(LinkedList<Prijava> tuu) {
        LinkedList<Igrac> prijavljeni= new LinkedList<>();
        for (Prijava prijava : tuu) {
            for (Igrac igr : listaIgraca) {
               
                if (prijava.getIgracID()==igr.getId() && !prijavljeni.contains(igr)){
                    igr.setPoeni(0);
                    prijavljeni.add(igr);
                    
                }
            }
        } System.out.println("broj igraca"+listaIgraca.size());
        System.out.println("prijavljenikLIJENT:"+prijavljeni);
        System.out.println("prijavljeniBROJ:"+prijavljeni.size());
        if (prijavljeni.size()<3){
            JOptionPane.showMessageDialog(frmglavna,"nema dovoljno prijavljenih igraca za ovaj turnir");
            frmglavna.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            frmglavna.getBtnSacuvaj().setEnabled(false);
            frmglavna.getBtnPlasman().setEnabled(false);
            frmglavna.getBtnUnesi().setEnabled(false);
        }
        frmglavna.setIGRACI(prijavljeni);
        srediPanel(prijavljeni);
        
    }

   
 public void dodajTurnir(String status) {
         JOptionPane.showMessageDialog(dodajturnir, status, "Status",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public DodajTurnir getDodajturnir() {
        return dodajturnir;
    }

    public void setDodajturnir(DodajTurnir dodajturnir) {
        this.dodajturnir = dodajturnir;
    }
   
}
