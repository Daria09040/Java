PGDMP     1    
                {            movies    15.2    15.2 	    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    16606    movies    DATABASE     z   CREATE DATABASE movies WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'Russian_Russia.1252';
    DROP DATABASE movies;
                postgres    false            �            1259    16607    movie    TABLE     �   CREATE TABLE public.movie (
    id integer NOT NULL,
    name character varying(255),
    genre character varying(255),
    duration integer,
    release integer
);
    DROP TABLE public.movie;
       public         heap    postgres    false            �            1259    16612    movie_id_seq    SEQUENCE     �   ALTER TABLE public.movie ALTER COLUMN id ADD GENERATED ALWAYS AS IDENTITY (
    SEQUENCE NAME public.movie_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1
);
            public          postgres    false    214            �          0    16607    movie 
   TABLE DATA           C   COPY public.movie (id, name, genre, duration, release) FROM stdin;
    public          postgres    false    214   �       �           0    0    movie_id_seq    SEQUENCE SET     :   SELECT pg_catalog.setval('public.movie_id_seq', 6, true);
          public          postgres    false    215            f           2606    16614    movie movie_pkey 
   CONSTRAINT     N   ALTER TABLE ONLY public.movie
    ADD CONSTRAINT movie_pkey PRIMARY KEY (id);
 :   ALTER TABLE ONLY public.movie DROP CONSTRAINT movie_pkey;
       public            postgres    false    214            �   �   x�]�=�0�g�\ ��лp��,Hk�	�T-Wx�NGd)N���=K8"��i�I�#t��V/O�?ģ�mz�5�lY:�״��]{��;A�d�(;��:C�19焳�UotRKCzx�鵂xM�-� ���:a�AG��KP�����Q��n����.A+�,�����     