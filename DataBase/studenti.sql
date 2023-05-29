DO $$ 
DECLARE
  lista_nume text[] := ARRAY['Ababei','Acasandrei','Adascalitei','Afanasie','Agafitei','Agape','Aioanei','Alexandrescu','Alexandru','Alexe','Alexii','Amarghioalei','Ambroci','Andonesei','Andrei','Andrian','Andrici','Andronic','Andros','Anghelina','Anita','Antochi','Antonie','Apetrei','Apostol','Arhip','Arhire','Arteni','Arvinte','Asaftei','Asofiei','Aungurenci','Avadanei','Avram','Babei','Baciu','Baetu','Balan','Balica','Banu','Barbieru','Barzu','Bazgan','Bejan','Bejenaru','Belcescu','Belciuganu','Benchea','Bilan','Birsanu','Bivol','Bizu','Boca','Bodnar','Boistean','Borcan','Bordeianu','Botezatu','Bradea','Braescu','Budaca','Bulai','Bulbuc-aioanei','Burlacu','Burloiu','Bursuc','Butacu','Bute','Buza','Calancea','Calinescu','Capusneanu','Caraiman','Carbune','Carp','Catana','Catiru','Catonoiu','Cazacu','Cazamir','Cebere','Cehan','Cernescu','Chelaru','Chelmu','Chelmus','Chibici','Chicos','Chilaboc','Chile','Chiriac','Chirila','Chistol','Chitic','Chmilevski','Cimpoesu','Ciobanu','Ciobotaru','Ciocoiu','Ciofu','Ciornei','Citea','Ciucanu','Clatinici','Clim','Cobuz','Coca','Cojocariu','Cojocaru','Condurache','Corciu','Corduneanu','Corfu','Corneanu','Corodescu','Coseru','Cosnita','Costan','Covatariu','Cozma','Cozmiuc','Craciunas','Crainiceanu','Creanga','Cretu','Cristea','Crucerescu','Cumpata','Curca','Cusmuliuc','Damian','Damoc','Daneliuc','Daniel','Danila','Darie','Dascalescu','Dascalu','Diaconu','Dima','Dimache','Dinu','Dobos','Dochitei','Dochitoiu','Dodan','Dogaru','Domnaru','Dorneanu','Dragan','Dragoman','Dragomir','Dragomirescu','Duceac','Dudau','Durnea','Edu','Eduard','Eusebiu','Fedeles','Ferestraoaru','Filibiu','Filimon','Filip','Florescu','Folvaiter','Frumosu','Frunza','Galatanu','Gavrilita','Gavriliuc','Gavrilovici','Gherase','Gherca','Ghergu','Gherman','Ghibirdic','Giosanu','Gitlan','Giurgila','Glodeanu','Goldan','Gorgan','Grama','Grigore','Grigoriu','Grosu','Grozavu','Gurau','Haba','Harabula','Hardon','Harpa','Herdes','Herscovici','Hociung','Hodoreanu','Hostiuc','Huma','Hutanu','Huzum','Iacob','Iacobuta','Iancu','Ichim','Iftimesei','Ilie','Insuratelu','Ionesei','Ionesi','Ionita','Iordache','Iordache-tiroiu','Iordan','Iosub','Iovu','Irimia','Ivascu','Jecu','Jitariuc','Jitca','Joldescu','Juravle','Larion','Lates','Latu','Lazar','Leleu','Leon','Leonte','Leuciuc','Leustean','Luca','Lucaci','Lucasi','Luncasu','Lungeanu','Lungu','Lupascu','Lupu','Macariu','Macoveschi','Maftei','Maganu','Mangalagiu','Manolache','Manole','Marcu','Marinov','Martinas','Marton','Mataca','Matcovici','Matei','Maties','Matrana','Maxim','Mazareanu','Mazilu','Mazur','Melniciuc-puica','Micu','Mihaela','Mihai','Mihaila','Mihailescu','Mihalachi','Mihalcea','Mihociu','Milut','Minea','Minghel','Minuti','Miron','Mitan','Moisa','Moniry-abyaneh','Morarescu','Morosanu','Moscu','Motrescu','Motroi','Munteanu','Murarasu','Musca','Mutescu','Nastaca','Nechita','Neghina','Negrus','Negruser','Negrutu','Nemtoc','Netedu','Nica','Nicu','Oana','Olanuta','Olarasu','Olariu','Olaru','Onu','Opariuc','Oprea','Ostafe','Otrocol','Palihovici','Pantiru','Pantiruc','Paparuz','Pascaru','Patachi','Patras','Patriche','Perciun','Perju','Petcu','Pila','Pintilie','Piriu','Platon','Plugariu','Podaru','Poenariu','Pojar','Popa','Popescu','Popovici','Poputoaia','Postolache','Predoaia','Prisecaru','Procop','Prodan','Puiu','Purice','Rachieru','Razvan','Reut','Riscanu','Riza','Robu','Roman','Romanescu','Romaniuc','Rosca','Rusu','Samson','Sandu','Sandulache','Sava','Savescu','Schifirnet','Scortanu','Scurtu','Sfarghiu','Silitra','Simiganoschi','Simion','Simionescu','Simionesei','Simon','Sitaru','Sleghel','Sofian','Soficu','Sparhat','Spiridon','Stan','Stavarache','Stefan','Stefanita','Stingaciu','Stiufliuc','Stoian','Stoica','Stoleru','Stolniceanu','Stolnicu','Strainu','Strimtu','Suhani','Tabusca','Talif','Tanasa','Teclici','Teodorescu','Tesu','Tifrea','Timofte','Tincu','Tirpescu','Toader','Tofan','Toma','Toncu','Trifan','Tudosa','Tudose','Tuduri','Tuiu','Turcu','Ulinici','Unghianu','Ungureanu','Ursache','Ursachi','Urse','Ursu','Varlan','Varteniuc','Varvaroi','Vasilache','Vasiliu','Ventaniuc','Vicol','Vidru','Vinatoru','Vlad','Voaides','Vrabie','Vulpescu','Zamosteanu','Zazuleac'];
  lista_prenume_fete text[] := ARRAY['Adina','Alexandra','Alina','Ana','Anca','Anda','Andra','Andreea','Andreia','Antonia','Bianca','Camelia','Claudia','Codrina','Cristina','Daniela','Daria','Delia','Denisa','Diana','Ecaterina','Elena','Eleonora','Elisa','Ema','Emanuela','Emma','Gabriela','Georgiana','Ileana','Ilona','Ioana','Iolanda','Irina','Iulia','Iuliana','Larisa','Laura','Loredana','Madalina','Malina','Manuela','Maria','Mihaela','Mirela','Monica','Oana','Paula','Petruta','Raluca','Sabina','Sanziana','Simina','Simona','Stefana','Stefania','Tamara','Teodora','Theodora','Vasilica','Xena'];
  lista_prenume_baieti text[] := ARRAY['Adrian','Alex','Alexandru','Alin','Andreas','Andrei','Aurelian','Beniamin','Bogdan','Camil','Catalin','Cezar','Ciprian','Claudiu','Codrin','Constantin','Corneliu','Cosmin','Costel','Cristian','Damian','Dan','Daniel','Danut','Darius','Denise','Dimitrie','Dorian','Dorin','Dragos','Dumitru','Eduard','Elvis','Emil','Ervin','Eugen','Eusebiu','Fabian','Filip','Florian','Florin','Gabriel','George','Gheorghe','Giani','Giulio','Iaroslav','Ilie','Ioan','Ion','Ionel','Ionut','Iosif','Irinel','Iulian','Iustin','Laurentiu','Liviu','Lucian','Marian','Marius','Matei','Mihai','Mihail','Nicolae','Nicu','Nicusor','Octavian','Ovidiu','Paul','Petru','Petrut','Radu','Rares','Razvan','Richard','Robert','Roland','Rolland','Romanescu','Sabin','Samuel','Sebastian','Sergiu','Silviu','Stefan','Teodor','Teofil','Theodor','Tudor','Vadim','Valentin','Valeriu','Vasile','Victor','Vlad','Vladimir','Vladut'];
      
  v_nume varchar(255);
  v_prenume varchar(255);
  v_prenume1 varchar(255);
  v_prenume2 varchar(255);
  v_matr varchar(6);
  v_temp int;
  v_temp1 int;
  v_temp2 int;
  v_temp3 int;
  v_temp_date date;
  v_an int;
  v_grupa varchar(2);
  v_bursa int;
  v_data_nastere date;  
  v_email varchar(40);
  v_gen varchar(2);
  v_medie numeric(3, 2);

BEGIN
   RAISE NOTICE 'Inserarea a 125 studenti...';
   FOR v_i IN 2..125 LOOP
      v_nume := lista_nume[1+floor(random()*(array_length(lista_nume, 1)-1+1))];
      
      IF random() < 0.5 THEN 
         v_gen := 'F';
         v_prenume1 := lista_prenume_fete[1+floor(random()*(array_length(lista_prenume_fete, 1)-1+1))];
         LOOP
            v_prenume2 := lista_prenume_fete[1+floor(random()*(array_length(lista_prenume_fete, 1)-1+1))];
            EXIT WHEN v_prenume1<>v_prenume2;
         END LOOP;
      ELSE
         v_gen := 'M';
         v_prenume1 := lista_prenume_baieti[1+floor(random()*(array_length(lista_prenume_baieti, 1)-1+1))];
         LOOP
            v_prenume2 := lista_prenume_baieti[1+floor(random()*(array_length(lista_prenume_baieti, 1)-1+1))];
            EXIT WHEN v_prenume1<>v_prenume2;
         END LOOP;       
      END IF;
     
      IF random() < 0.6 THEN  
         v_prenume := v_prenume1 || ' ' || v_prenume2;
      ELSE 
         v_prenume := v_prenume1;
      END IF;       
       
      LOOP
         v_matr := floor(random()*(999-100+1))::int || chr(floor(random()*(91-65+1))::int + 65) || chr(floor(random()*(91-65+1))::int + 65) || floor(random()*(9-0+1))::int;
         SELECT COUNT(*) INTO v_temp FROM studenti WHERE nr_matricol = v_matr;
         EXIT WHEN v_temp=0;
      END LOOP;
              
      LOOP      
         v_an := floor(random()*(3-0+1))::int + 1;
         v_grupa := chr(floor(random()*(2-0+1))::int + 65) || chr(floor(random()*(6-0+1))::int + 49);
         SELECT COUNT(*) INTO v_temp FROM studenti WHERE an=v_an AND grupa=v_grupa;
         EXIT WHEN v_temp < 30;
      END LOOP;
      
      v_bursa := NULL;
      IF random() < 0.1 THEN
         v_bursa := floor(random()*(10-0+1))::int * 100 + 500;
      END IF;
      
      v_data_nastere := DATE '1974-01-01' + floor(random()*(365-0+1))::int;
      
      v_temp:=-1;
      v_email := lower(v_nume ||'.'|| v_prenume1);
      LOOP         
         SELECT COUNT(*) INTO v_temp FROM studenti WHERE email = v_email||v_temp;
         EXIT WHEN v_temp=0;
         v_temp :=  floor(random()*(100-0+1))::int;
      END LOOP;    
      
      IF floor(random()*(2-0+1))::int = 0 THEN 
         v_email := v_email ||'@gmail.com';
      ELSE 
         v_email := v_email ||'@info.ro';
      END IF;
	      v_medie := floor(random() * (10 - 5 + 1))::numeric + (floor(random() * (100 - 0 + 1))::numeric / 100);

                      
      INSERT INTO studenti VALUES (v_i, v_matr, v_nume, v_prenume, v_an, v_grupa, v_data_nastere, v_email, v_medie, 'f');
   END LOOP;
   
   RAISE NOTICE 'Inserarea a 1025 studenti... GATA !';
END $$;
