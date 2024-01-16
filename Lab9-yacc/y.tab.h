
/* A Bison parser, made by GNU Bison 2.4.1.  */

/* Skeleton interface for Bison's Yacc-like parsers in C
   
      Copyright (C) 1984, 1989, 1990, 2000, 2001, 2002, 2003, 2004, 2005, 2006
   Free Software Foundation, Inc.
   
   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.
   
   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   
   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <http://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.
   
   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */


/* Tokens.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
   /* Put the tokens into the symbol table, so that GDB and other debuggers
      know about them.  */
   enum yytokentype {
     IF = 258,
     AT = 259,
     ELSE = 260,
     READ = 261,
     WRITE = 262,
     INTEGER = 263,
     STRING = 264,
     FOR = 265,
     IN = 266,
     RANGE = 267,
     WHILE = 268,
     plus = 269,
     minus = 270,
     mul = 271,
     division = 272,
     mod = 273,
     lessOrEqual = 274,
     moreOrEqual = 275,
     less = 276,
     more = 277,
     equal = 278,
     different = 279,
     eq = 280,
     and = 281,
     or = 282,
     leftCurlyBracket = 283,
     rightCurlyBracket = 284,
     leftRoundBracket = 285,
     rightRoundBracket = 286,
     leftBracket = 287,
     rightBracket = 288,
     colon = 289,
     semicolon = 290,
     comma = 291,
     apostrophe = 292,
     quote = 293,
     space = 294,
     dot = 295,
     IDENTIFIER = 296,
     NUMBER_CONST = 297,
     STRING_CONST = 298
   };
#endif
/* Tokens.  */
#define IF 258
#define AT 259
#define ELSE 260
#define READ 261
#define WRITE 262
#define INTEGER 263
#define STRING 264
#define FOR 265
#define IN 266
#define RANGE 267
#define WHILE 268
#define plus 269
#define minus 270
#define mul 271
#define division 272
#define mod 273
#define lessOrEqual 274
#define moreOrEqual 275
#define less 276
#define more 277
#define equal 278
#define different 279
#define eq 280
#define and 281
#define or 282
#define leftCurlyBracket 283
#define rightCurlyBracket 284
#define leftRoundBracket 285
#define rightRoundBracket 286
#define leftBracket 287
#define rightBracket 288
#define colon 289
#define semicolon 290
#define comma 291
#define apostrophe 292
#define quote 293
#define space 294
#define dot 295
#define IDENTIFIER 296
#define NUMBER_CONST 297
#define STRING_CONST 298




#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define yystype YYSTYPE /* obsolescent; will be withdrawn */
# define YYSTYPE_IS_DECLARED 1
#endif

extern YYSTYPE yylval;


