
select * from colegi;
delete from colegi;

DO $$
DECLARE
   v_temp integer;
   v_temp1 integer;
   v_temp2 integer;
   v_data_nastere DATE;
BEGIN
   SELECT count(*) INTO v_temp FROM studenti;

   FOR v_i IN 1..125 LOOP
      LOOP
         v_temp1 := trunc(random() * (v_temp - 1) + 1);
         v_temp2 := trunc(random() * (v_temp - 1) + 1);
         EXIT WHEN v_temp1 <> v_temp2;
      END LOOP;

      BEGIN
         v_data_nastere := CURRENT_DATE - (trunc(random() * 1000) || ' days')::interval;
         INSERT INTO colegi VALUES (v_i, v_temp1, v_temp2, v_data_nastere, v_data_nastere);
         EXCEPTION
            WHEN OTHERS THEN NULL;
      END;
   END LOOP;
  END $$;





