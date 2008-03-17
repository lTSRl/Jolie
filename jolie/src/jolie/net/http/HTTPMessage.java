/***************************************************************************
 *   Copyright (C) by Fabrizio Montesi                                     *
 *                                                                         *
 *   This program is free software; you can redistribute it and/or modify  *
 *   it under the terms of the GNU Library General Public License as       *
 *   published by the Free Software Foundation; either version 2 of the    *
 *   License, or (at your option) any later version.                       *
 *                                                                         *
 *   This program is distributed in the hope that it will be useful,       *
 *   but WITHOUT ANY WARRANTY; without even the implied warranty of        *
 *   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the         *
 *   GNU General Public License for more details.                          *
 *                                                                         *
 *   You should have received a copy of the GNU Library General Public     *
 *   License along with this program; if not, write to the                 *
 *   Free Software Foundation, Inc.,                                       *
 *   59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.             *
 *                                                                         *
 *   For details about the authors of this software, see the AUTHORS file. *
 ***************************************************************************/

package jolie.net.http;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


public class HTTPMessage
{
	public enum Type {
		RESPONSE, POST, GET, ERROR
	}
	
	public enum Version {
		HTTP_1_0, HTTP_1_1
	}

	private Version version;
	private Type type;
	private byte[] content = null;
	private Map< String, String > propMap = new HashMap< String, String > ();
	
	private int httpCode;
	private String requestPath;
	private String reason;

	public HTTPMessage( Type type )
	{
		this.type = type;
	}
	
	protected void setVersion( Version version )
	{
		this.version = version;
	}
	
	public Version version()
	{
		return version;
	}
	
	public void setContent( byte[] content )
	{
		this.content = content;
	}
	
	public Collection< Entry< String, String > > properties()
	{
		return propMap.entrySet();
	}
	
	public void setRequestPath( String path )
	{
		requestPath = path;
	}
	
	public void setProperty( String name, String value )
	{
		propMap.put( name, value );
	}
	
	public String getProperty( String name )
	{
		return propMap.get( name );
	}
	
	public String getPropertyOrEmptyString( String name )
	{
		String ret = propMap.get( name );
		return ( ret == null ) ? "" : ret;
	}
	
	public String reason()
	{
		return reason;
	}
	
	public void setReason( String reason )
	{
		this.reason = reason;
	}
	
	public int size()
	{
		if ( content == null )
			return 0;
		return content.length;
	}
	
	public String requestPath()
	{
		return requestPath;
	}
	
	public Type type()
	{
		return type;
	}
	
	public int httpCode()
	{
		return httpCode;
	}
	
	public void setHttpCode( int code )
	{
		httpCode = code;
	}
	
	public byte[] content()
	{
		return content;
	}
}
