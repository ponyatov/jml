
// line 1 "Lexer.ragel"
package metal;

import frame.Symbol;
import frame.VM;
import java.util.Arrays;


// line 28 "Lexer.ragel"


/**
 * <b>metaL</b> language parser implemented with <a href="http://www.colm.net/open-source/ragel/">Ragel</a> generator tool
 * */
public class Lexer {
	
	
// line 20 "Lexer.java"
private static byte[] init__lexer_actions_0()
{
	return new byte [] {
	    0,    1,    0,    1,    1,    1,    2,    1,    3,    1,    4
	};
}

private static final byte _lexer_actions[] = init__lexer_actions_0();


private static byte[] init__lexer_key_offsets_0()
{
	return new byte [] {
	    0,    6,   10,   14,   18
	};
}

private static final byte _lexer_key_offsets[] = init__lexer_key_offsets_0();


private static char[] init__lexer_trans_keys_0()
{
	return new char [] {
	   13,   32,   35,   92,    9,   10,   13,   32,    9,   10,   13,   32,
	    9,   10,    9,   10,   13,   32,   10,    0
	};
}

private static final char _lexer_trans_keys[] = init__lexer_trans_keys_0();


private static byte[] init__lexer_single_lengths_0()
{
	return new byte [] {
	    4,    2,    2,    4,    1
	};
}

private static final byte _lexer_single_lengths[] = init__lexer_single_lengths_0();


private static byte[] init__lexer_range_lengths_0()
{
	return new byte [] {
	    1,    1,    1,    0,    0
	};
}

private static final byte _lexer_range_lengths[] = init__lexer_range_lengths_0();


private static byte[] init__lexer_index_offsets_0()
{
	return new byte [] {
	    0,    6,   10,   14,   19
	};
}

private static final byte _lexer_index_offsets[] = init__lexer_index_offsets_0();


private static byte[] init__lexer_indicies_0()
{
	return new byte [] {
	    1,    1,    2,    2,    1,    0,    3,    3,    3,    0,    1,    1,
	    1,    4,    6,    5,    6,    6,    2,    5,    6,    0
	};
}

private static final byte _lexer_indicies[] = init__lexer_indicies_0();


private static byte[] init__lexer_trans_targs_0()
{
	return new byte [] {
	    1,    2,    3,    0,    0,    0,    4
	};
}

private static final byte _lexer_trans_targs[] = init__lexer_trans_targs_0();


private static byte[] init__lexer_trans_actions_0()
{
	return new byte [] {
	    0,    0,    0,    9,    7,    5,    0
	};
}

private static final byte _lexer_trans_actions[] = init__lexer_trans_actions_0();


private static byte[] init__lexer_to_state_actions_0()
{
	return new byte [] {
	    1,    0,    0,    0,    0
	};
}

private static final byte _lexer_to_state_actions[] = init__lexer_to_state_actions_0();


private static byte[] init__lexer_from_state_actions_0()
{
	return new byte [] {
	    3,    0,    0,    0,    0
	};
}

private static final byte _lexer_from_state_actions[] = init__lexer_from_state_actions_0();


private static byte[] init__lexer_eof_trans_0()
{
	return new byte [] {
	    0,    4,    5,    6,    6
	};
}

private static final byte _lexer_eof_trans[] = init__lexer_eof_trans_0();


static final int lexer_start = 0;
static final int lexer_first_final = 0;
static final int lexer_error = -1;

static final int lexer_en_metaL = 0;


// line 36 "Lexer.ragel"
	
		VM vm;
	     int p   = 0;					// current parsing position
	     int pe  = 0;					// end of source text marker
	     int eof = 0;
	     char[] data;
	     boolean flag = false;

	/**
	 * feed source code
	 * @param context provide VM as execution context
	 * @param cmd source code/command string in metaL language
	 * */
	public void input(metaL context, String cmd) {
			 vm = context;
		   data = cmd.toCharArray();	// parser requires sequence storage
	          p = 0;					// reset to start
	         pe = data.length;			// reset to end
	        eof = data.length;			// end of source index
	       flag = false;
	}
	
	/**
	 * get next token
	 * @return false if end of source code
	 * */
	public boolean token() {
	
		if (p==pe) { flag=false; return flag; }
		
	     int cs = lexer_start;			// state machine current state
	     int ts = 0;					// Token Start pointer
	     int te = 0;					// Token End   pointer
	     
	
// line 186 "Lexer.java"
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
// line 211 "Lexer.java"
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
// line 17 "Lexer.ragel"
	{te = p;p--;{ flag=true; { p += 1; _goto_targ = 5; if (true)  continue _goto;} }}
	break;
	case 3:
// line 17 "Lexer.ragel"
	{te = p;p--;{ flag=true; { p += 1; _goto_targ = 5; if (true)  continue _goto;} }}
	break;
	case 4:
// line 12 "Lexer.ragel"
	{te = p;p--;{
		vm.push(new Symbol(new String(Arrays.copyOfRange(data,ts,te))));
		flag=true; { p += 1; _goto_targ = 5; if (true)  continue _goto;}
	}}
	break;
// line 290 "Lexer.java"
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
// line 304 "Lexer.java"
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

// line 71 "Lexer.ragel"
	
		return false;
	
	}
}
