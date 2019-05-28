
// line 1 "Lexer.ragel"

// line 22 "Lexer.ragel"


package metal;

import frame.Frame;
import frame.Sym;
import frame.Num;
import frame.Int;
import frame.Hex;
import frame.Bin;

import java.util.Arrays;

public class Lexer {

    int cs,p,pe,eof,ts,te,act;
    char[] data;

    
// line 25 "Lexer.java"
private static byte[] init__lexer_actions_0()
{
	return new byte [] {
	    0,    1,    0,    1,    1,    1,    7,    1,    8,    1,    9,    1,
	   10,    1,   11,    1,   12,    2,    2,    3,    2,    2,    4,    2,
	    2,    5,    2,    2,    6
	};
}

private static final byte _lexer_actions[] = init__lexer_actions_0();


private static byte[] init__lexer_key_offsets_0()
{
	return new byte [] {
	    0,   12,   16,   20,   24,   25,   32,   38,   46,   54,   60,   69,
	   80,   86
	};
}

private static final byte _lexer_key_offsets[] = init__lexer_key_offsets_0();


private static char[] init__lexer_trans_keys_0()
{
	return new char [] {
	   13,   32,   35,   43,   45,   46,   48,   92,    9,   10,   49,   57,
	   13,   32,    9,   10,   13,   32,    9,   10,    9,   10,   13,   32,
	   10,   13,   32,   46,    9,   10,   48,   57,   13,   32,    9,   10,
	   48,   57,   13,   32,   69,  101,    9,   10,   48,   57,   13,   32,
	   43,   45,    9,   10,   48,   57,   13,   32,    9,   10,   48,   57,
	   13,   32,   46,   69,  101,    9,   10,   48,   57,   13,   32,   46,
	   69,   98,  101,  120,    9,   10,   48,   57,   13,   32,    9,   10,
	   48,   49,   13,   32,    9,   10,   48,   57,   65,   70,   97,  102,
	    0
	};
}

private static final char _lexer_trans_keys[] = init__lexer_trans_keys_0();


private static byte[] init__lexer_single_lengths_0()
{
	return new byte [] {
	    8,    2,    2,    4,    1,    3,    2,    4,    4,    2,    5,    7,
	    2,    2
	};
}

private static final byte _lexer_single_lengths[] = init__lexer_single_lengths_0();


private static byte[] init__lexer_range_lengths_0()
{
	return new byte [] {
	    2,    1,    1,    0,    0,    2,    2,    2,    2,    2,    2,    2,
	    2,    4
	};
}

private static final byte _lexer_range_lengths[] = init__lexer_range_lengths_0();


private static byte[] init__lexer_index_offsets_0()
{
	return new byte [] {
	    0,   11,   15,   19,   24,   26,   32,   37,   44,   51,   56,   64,
	   74,   79
	};
}

private static final byte _lexer_index_offsets[] = init__lexer_index_offsets_0();


private static byte[] init__lexer_indicies_0()
{
	return new byte [] {
	    1,    1,    2,    3,    3,    4,    5,    2,    1,    6,    0,    7,
	    7,    7,    0,    1,    1,    1,    8,   10,    9,   10,   10,    2,
	    9,   10,    7,    7,    4,    7,    6,    0,    7,    7,    7,   11,
	    0,   12,   12,   13,   13,   12,   11,    0,    7,    7,   14,   14,
	    7,   15,    0,   16,   16,   16,   15,    0,   17,   17,   11,   13,
	   13,   17,    6,    0,   17,   17,   11,   13,   18,   13,   19,   17,
	    6,    0,   16,   16,   16,   20,    0,   16,   16,   16,   21,   21,
	   21,    0,    0
	};
}

private static final byte _lexer_indicies[] = init__lexer_indicies_0();


private static byte[] init__lexer_trans_targs_0()
{
	return new byte [] {
	    1,    2,    3,    5,    6,   11,   10,    0,    0,    0,    4,    7,
	    0,    8,    9,    9,    0,    0,   12,   13,   12,   13
	};
}

private static final byte _lexer_trans_targs[] = init__lexer_trans_targs_0();


private static byte[] init__lexer_trans_actions_0()
{
	return new byte [] {
	    0,    0,    0,    0,    0,    0,    0,   13,    7,    5,    0,    0,
	    9,    0,   26,   23,   15,   11,   26,   26,   20,   17
	};
}

private static final byte _lexer_trans_actions[] = init__lexer_trans_actions_0();


private static byte[] init__lexer_to_state_actions_0()
{
	return new byte [] {
	    1,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
	    0,    0
	};
}

private static final byte _lexer_to_state_actions[] = init__lexer_to_state_actions_0();


private static byte[] init__lexer_from_state_actions_0()
{
	return new byte [] {
	    3,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,    0,
	    0,    0
	};
}

private static final byte _lexer_from_state_actions[] = init__lexer_from_state_actions_0();


private static byte[] init__lexer_eof_trans_0()
{
	return new byte [] {
	    0,    8,    9,   10,   10,    8,    8,   13,    8,   17,   18,   18,
	   17,   17
	};
}

private static final byte _lexer_eof_trans[] = init__lexer_eof_trans_0();


static final int lexer_start = 0;
static final int lexer_first_final = 0;
static final int lexer_error = -1;

static final int lexer_en_FORTH = 0;


// line 41 "Lexer.ragel"

    public Lexer() { input(""); }
    
    private String tok(int offset) {
    	return new String(Arrays.copyOfRange(data,ts+offset,te));
    }
    
    public void input(String command) {
          cs = lexer_start;
        data = command.toCharArray();
           p = 0;
          pe = data.length;
         eof = pe;
       token = null;
    }

    private Frame token = null;

    public void _token() {
        
// line 200 "Lexer.java"
	{
	int _klen;
	int _trans = 0;
	int _acts;
	int _nacts;
	int _keys;
	int _goto_targ = 0;

	_goto: while (true) {
	switch ( _goto_targ ) {
	case 0:
	if ( p == pe ) {
		_goto_targ = 4;
		continue _goto;
	}
case 1:
	_acts = _lexer_from_state_actions[cs];
	_nacts = (int) _lexer_actions[_acts++];
	while ( _nacts-- > 0 ) {
		switch ( _lexer_actions[_acts++] ) {
	case 1:
// line 1 "NONE"
	{ts = p;}
	break;
// line 225 "Lexer.java"
		}
	}

	_match: do {
	_keys = _lexer_key_offsets[cs];
	_trans = _lexer_index_offsets[cs];
	_klen = _lexer_single_lengths[cs];
	if ( _klen > 0 ) {
		int _lower = _keys;
		int _mid;
		int _upper = _keys + _klen - 1;
		while (true) {
			if ( _upper < _lower )
				break;

			_mid = _lower + ((_upper-_lower) >> 1);
			if ( data[p] < _lexer_trans_keys[_mid] )
				_upper = _mid - 1;
			else if ( data[p] > _lexer_trans_keys[_mid] )
				_lower = _mid + 1;
			else {
				_trans += (_mid - _keys);
				break _match;
			}
		}
		_keys += _klen;
		_trans += _klen;
	}

	_klen = _lexer_range_lengths[cs];
	if ( _klen > 0 ) {
		int _lower = _keys;
		int _mid;
		int _upper = _keys + (_klen<<1) - 2;
		while (true) {
			if ( _upper < _lower )
				break;

			_mid = _lower + (((_upper-_lower) >> 1) & ~1);
			if ( data[p] < _lexer_trans_keys[_mid] )
				_upper = _mid - 2;
			else if ( data[p] > _lexer_trans_keys[_mid+1] )
				_lower = _mid + 2;
			else {
				_trans += ((_mid - _keys)>>1);
				break _match;
			}
		}
		_trans += _klen;
	}
	} while (false);

	_trans = _lexer_indicies[_trans];
case 3:
	cs = _lexer_trans_targs[_trans];

	if ( _lexer_trans_actions[_trans] != 0 ) {
		_acts = _lexer_trans_actions[_trans];
		_nacts = (int) _lexer_actions[_acts++];
		while ( _nacts-- > 0 )
	{
			switch ( _lexer_actions[_acts++] )
			{
	case 2:
// line 1 "NONE"
	{te = p+1;}
	break;
	case 3:
// line 16 "Lexer.ragel"
	{act = 3;}
	break;
	case 4:
// line 17 "Lexer.ragel"
	{act = 4;}
	break;
	case 5:
// line 18 "Lexer.ragel"
	{act = 5;}
	break;
	case 6:
// line 20 "Lexer.ragel"
	{act = 7;}
	break;
	case 7:
// line 14 "Lexer.ragel"
	{te = p;p--;}
	break;
	case 8:
// line 15 "Lexer.ragel"
	{te = p;p--;}
	break;
	case 9:
// line 18 "Lexer.ragel"
	{te = p;p--;{ token = new Num(tok(0)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }}
	break;
	case 10:
// line 19 "Lexer.ragel"
	{te = p;p--;{ token = new Int(tok(0)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }}
	break;
	case 11:
// line 20 "Lexer.ragel"
	{te = p;p--;{ token = new Sym(tok(0)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }}
	break;
	case 12:
// line 1 "NONE"
	{	switch( act ) {
	case 3:
	{{p = ((te))-1;} token = new Hex(tok(2)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }
	break;
	case 4:
	{{p = ((te))-1;} token = new Bin(tok(2)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }
	break;
	case 5:
	{{p = ((te))-1;} token = new Num(tok(0)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }
	break;
	case 7:
	{{p = ((te))-1;} token = new Sym(tok(0)); { p += 1; _goto_targ = 5; if (true)  continue _goto;} }
	break;
	}
	}
	break;
// line 347 "Lexer.java"
			}
		}
	}

case 2:
	_acts = _lexer_to_state_actions[cs];
	_nacts = (int) _lexer_actions[_acts++];
	while ( _nacts-- > 0 ) {
		switch ( _lexer_actions[_acts++] ) {
	case 0:
// line 1 "NONE"
	{ts = -1;}
	break;
// line 361 "Lexer.java"
		}
	}

	if ( ++p != pe ) {
		_goto_targ = 1;
		continue _goto;
	}
case 4:
	if ( p == eof )
	{
	if ( _lexer_eof_trans[cs] > 0 ) {
		_trans = _lexer_eof_trans[cs] - 1;
		_goto_targ = 3;
		continue _goto;
	}
	}

case 5:
	}
	break; }
	}

// line 61 "Lexer.ragel"
    }

    public Frame token() {
        token = null;
        _token();
        return token;
    }

};
