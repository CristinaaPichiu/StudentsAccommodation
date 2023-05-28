CREATE OR REPLACE FUNCTION how_many_colleagues(p_id INTEGER)
RETURNS INTEGER AS
$$
DECLARE 
	v_numara INTEGER;
	v_student_id RECORD; -- Adăugați o variabilă pentru a reține id-ul colegului
BEGIN
	v_numara := 0;

	-- Utilizați INTO pentru a atribui valoarea din interogare variabilei
	FOR v_student_id IN (
		SELECT id_student1
		FROM colegi
		WHERE id_student2 = p_id

		UNION

		SELECT id_student2
		FROM colegi
		WHERE id_student1 = p_id
	)
	LOOP
		v_numara := v_numara + 1;
	END LOOP;

	RETURN v_numara;
END;
$$
LANGUAGE plpgsql;


CREATE OR REPLACE FUNCTION build_json (
    p_id1     INTEGER,
    p_id2     INTEGER,
    p_id3     INTEGER,
    p_id4     INTEGER,
    p_id5     INTEGER,
    p_initial INTEGER
) RETURNS VARCHAR AS
$$
DECLARE 
	v_index   INTEGER;
	v_id      INTEGER;
	v_nume    VARCHAR(100);
	v_prenume VARCHAR(100);
	v_index1  INTEGER;
	v_count   INTEGER;
	v_count1  INTEGER;
	it RECORD;
	it2 RECORD;
	json      json;
	jsonStrg VARCHAR;
BEGIN
	v_count := 0;
	v_count1 := 0;
	v_index := 0;
	v_index1 := 0;

	SELECT id, nume, prenume
	INTO v_id, v_nume, v_prenume
	FROM studenti
	WHERE id = p_id1;

	FOR it IN (
		SELECT id_student1
		FROM colegi
		WHERE id_student2 = p_initial

		UNION

		SELECT id_student2
		FROM colegi
		WHERE id_student1 = p_initial
	)
	LOOP
		FOR it2 IN (
			SELECT id_student1
			FROM colegi
			WHERE id_student2 = it.id_student1
		)
		LOOP
			SELECT count(*) INTO v_count
			FROM colegi
			WHERE id_student1 = it2.id_student1 AND id_student2 = p_id1;

			IF v_count > 0 THEN
				v_index := v_index + 1;
			END IF;
		END LOOP;
	END LOOP;

	json := json_build_object(
		'id', p_id1,
		'nume', v_nume,
		'prenume', v_prenume,
		'colegi', v_index
	);

	v_index := 0;

	SELECT id, nume, prenume
	INTO v_id, v_nume, v_prenume
	FROM studenti
	WHERE id = p_id2;

	FOR it IN (
		SELECT id_student1
		FROM colegi
		WHERE id_student2 = p_initial

		UNION

		SELECT id_student2
		FROM colegi
		WHERE id_student1 = p_initial
	)
	LOOP
		FOR it2 IN (
			SELECT id_student1
			FROM colegi
			WHERE id_student2 = it.id_student1
		)
		LOOP
			SELECT count(*) INTO v_count
			FROM colegi
			WHERE id_student1 = it2.id_student1 AND id_student2 = p_id2;

			IF v_count > 0 THEN
				v_index := v_index + 1;
			END IF;
		END LOOP;
	END LOOP;

	jsonStrg := json::VARCHAR || json_build_object(
		'id', p_id2,
		'nume', v_nume,
		'prenume', v_prenume,
		'colegi', v_index
	)::VARCHAR;

	v_index := 0;

	SELECT id, nume, prenume
	INTO v_id, v_nume, v_prenume
	FROM studenti
	WHERE id = p_id3;

	FOR it IN (
		SELECT id_student1
		FROM colegi
		WHERE id_student2 = p_initial

		UNION

		SELECT id_student2
		FROM colegi
		WHERE id_student1 = p_initial
	)
	LOOP
		FOR it2 IN (
			SELECT id_student1
			FROM colegi
			WHERE id_student2 = it.id_student1
		)
		LOOP
			SELECT count(*) INTO v_count
			FROM colegi
			WHERE id_student1 = it2.id_student1 AND id_student2 = p_id3;

			IF v_count > 0 THEN
				v_index := v_index + 1;
			END IF;
		END LOOP;
	END LOOP;

	jsonStrg := jsonStrg || json_build_object(
		'id', p_id3,
		'nume', v_nume,
		'prenume', v_prenume,
		'colegi', v_index
	)::VARCHAR;

	v_index := 0;

	SELECT id, nume, prenume
	INTO v_id, v_nume, v_prenume
	FROM studenti
	WHERE id = p_id4;

	FOR it IN (
		SELECT id_student1
		FROM colegi
		WHERE id_student2 = p_initial

		UNION

		SELECT id_student2
		FROM colegi
		WHERE id_student1 = p_initial
	)
	LOOP
		FOR it2 IN (
			SELECT id_student1
			FROM colegi
			WHERE id_student2 = it.id_student1
		)
		LOOP
			SELECT count(*) INTO v_count
			FROM colegi
			WHERE id_student1 = it2.id_student1 AND id_student2 = p_id4;

			IF v_count > 0 THEN
				v_index := v_index + 1;
			END IF;
		END LOOP;
	END LOOP;

	jsonStrg := jsonStrg || json_build_object(
		'id', p_id4,
		'nume', v_nume,
		'prenume', v_prenume,
		'colegi', v_index
	)::VARCHAR;

	v_index := 0;

	SELECT id, nume, prenume
	INTO v_id, v_nume, v_prenume
	FROM studenti
	WHERE id = p_id5;

	FOR it IN (
		SELECT id_student1
		FROM colegi
		WHERE id_student2 = p_initial

		UNION

		SELECT id_student2
		FROM colegi
		WHERE id_student1 = p_initial
	)
	LOOP
		FOR it2 IN (
			SELECT id_student1
			FROM colegi
			WHERE id_student2 = it.id_student1
		)
		LOOP
			SELECT count(*) INTO v_count
			FROM colegi
			WHERE id_student1 = it2.id_student1 AND id_student2 = p_id5;

			IF v_count > 0 THEN
				v_index := v_index + 1;
			END IF;
		END LOOP;
	END LOOP;

	jsonStrg := jsonStrg || json_build_object(
		'id', p_id5,
		'nume', v_nume,
		'prenume', v_prenume,
		'colegi', v_index
	)::VARCHAR;

	RETURN jsonStrg;
END;
$$
LANGUAGE plpgsql;




CREATE OR REPLACE FUNCTION verifica_colegi (
    p_id1 INTEGER,
    p_id2 INTEGER
) RETURNS INTEGER AS
$$
DECLARE
    v_valid INTEGER := 1;
    v_index INTEGER := 0;
    c RECORD;
BEGIN
    FOR c IN (
        SELECT id_student2
        FROM colegi
        WHERE id_student1 = p_id2
    ) LOOP
        IF c.id_student2 = p_id1 THEN
            v_valid := 0;
        END IF;
    END LOOP;

    FOR c IN (
        SELECT id_student1
        FROM colegi
        WHERE id_student2 = p_id2
    ) LOOP
        IF c.id_student1 = p_id1 THEN
            v_valid := 0;
        END IF;
    END LOOP;

    RETURN v_valid;
END;
$$
LANGUAGE plpgsql;




CREATE OR REPLACE FUNCTION get_colegi_proj (
    p_id INTEGER
) 
RETURNS VARCHAR AS
$$
DECLARE
    v_id       INTEGER;
    v_rezultat VARCHAR(1000) := '';
    v_index    INTEGER;
    colegii  VARCHAR[];
    v_numara   INTEGER := 1;
    v_maxim1   INTEGER := 0;
    v_maxim2   INTEGER := 0;
    v_maxim3   INTEGER := 0;
    v_maxim4   INTEGER := 0;
    v_maxim5   INTEGER := 0;
    v_id1      INTEGER;
    v_id2      INTEGER;
    v_id3      INTEGER;
    v_id4      INTEGER;
    v_id5      INTEGER;
    v_string   VARCHAR(1000);
	swapped    BOOLEAN;
	tmp VARCHAR;
	c RECORD;
	i RECORD;
BEGIN
    v_index := 1;
	colegii := ARRAY[]::VARCHAR[];
    FOR c IN (
        SELECT
            id_student1
        FROM
            colegi
        WHERE
            id_student2 = p_id
    ) LOOP
        FOR i IN (
            SELECT
                id_student1
            FROM
                colegi
            WHERE
                id_student2 = c.id_student1
        ) LOOP
            IF ( verifica_colegi(i.id_student1, p_id) = 1 ) THEN
                colegii[v_index] := i.id_student1;
                v_index := v_index + 1;
            END IF;
        END LOOP;

        FOR i IN (
            SELECT
                id_student2
            FROM
                colegi
            WHERE
                id_student1 = c.id_student1
        ) LOOP
            IF ( verifica_colegi(i.id_student2, p_id) = 1 ) THEN
                colegii[v_index] := i.id_student2;
                v_index := v_index + 1;
            END IF;
        END LOOP;

    END LOOP;
	
	 FOR c IN (
        SELECT
            id_student2
        FROM
            colegi
        WHERE
            id_student1 = p_id
    ) LOOP
        v_id := 0;
        FOR i IN (
            SELECT
                id_student1
            FROM
                colegi
            WHERE
                id_student2 = c.id_student2
        ) LOOP
            IF ( verifica_colegi(i.id_student1, p_id) = 1 ) THEN
                colegii[v_index] := i.id_student1;
                v_index := v_index + 1;
            END IF;
        END LOOP;

        FOR i IN (
            SELECT
                id_student2
            FROM
                colegi
            WHERE
                id_student1 = c.id_student2
        ) LOOP
            IF ( verifica_colegi(i.id_student2, p_id) = 1 ) THEN
                colegii[v_index] := i.id_student2;
                v_index := v_index + 1;
            END IF;
        END LOOP;

    END LOOP;

    LOOP
    swapped := false;
    FOR i IN 2..array_length(colegii, 1) LOOP
        IF colegii[i - 1] > colegii[i] THEN
            tmp := colegii[i];
            colegii[i] := colegii[i - 1];
            colegii[i - 1] := tmp;
            swapped := true;
        END IF;
    END LOOP;

    EXIT WHEN NOT swapped;
END LOOP;

    FOR i IN 1..array_length(colegii, 1) LOOP
        Raise Notice 'Elementele din vectorul sortat sunt: %' , colegii[i];
	END LOOP;

    v_maxim1 := 0;
    v_maxim2 := 0;
    v_maxim3 := 0;
    v_maxim4 := 0;
    v_maxim5 := 0;
    FOR i IN 2..array_length(colegii, 1) LOOP
        IF colegii[i - 1] = colegii[i] THEN
            v_numara := v_numara + 1;
			RAISE NOTICE 'v_numara = %', v_numara;
        ELSE
            IF (v_numara > v_maxim1 ) THEN
				RAISE  NOTICE 'v_numara = %', v_numara;
                v_maxim5 := v_maxim4;
                v_maxim4 := v_maxim3;
                v_maxim3 := v_maxim2;
                v_maxim2 := v_maxim1;
                v_maxim1 := v_numara+2;
                v_id1 := colegii[i - 1];
				RAISE NOTICE 'v_id1 = %', v_id1;
            ELSIF ( v_numara > v_maxim2 ) THEN
				RAISE NOTICE 'v_numara = %', v_numara;
                v_maxim5 := v_maxim4;
                v_maxim4 := v_maxim3;
                v_maxim3 := v_maxim2;
                v_maxim2 := v_numara+2;
                v_id2 := colegii[i - 1];
				RAISE NOTICE 'v_id2 = %', v_id2;
            ELSIF ( v_numara > v_maxim3 ) THEN
				RAISE NOTICE 'v_numara = %', v_numara;
                v_maxim5 := v_maxim4;
                v_maxim4 := v_maxim3;
                v_maxim3 := v_numara+2;
                v_id3 := colegii[i - 1];
				RAISE NOTICE 'v_id3 = %', v_id3;
            ELSIF ( v_numara > v_maxim4 ) THEN
				RAISE NOTICE 'v_numara = %', v_numara;
                v_maxim5 := v_maxim4;
                v_maxim4 := v_numara+2;
                v_id4 := colegii[i - 1];
				RAISE NOTICE 'v_id3 = %', v_id3;
            ELSIF ( v_numara > v_maxim5 ) THEN
				RAISE NOTICE 'v_numara = %', v_numara;
                v_maxim5 := v_numara+2;
                v_id5 := colegii[i - 1];
				RAISE NOTICE 'v_id4 = %', v_id4;
            END IF;

        END IF;
    END LOOP;

    v_string := build_json(v_id1,v_id2,v_id3,v_id4,v_id5,p_id);

    RETURN v_string;
END;
$$
LANGUAGE plpgsql;