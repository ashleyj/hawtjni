/*******************************************************************************
 * Copyright (c) 2009 Progress Software, Inc.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package test;

import org.fusesource.hawtjni.runtime.JniArg;
import org.fusesource.hawtjni.runtime.JniClass;
import org.fusesource.hawtjni.runtime.JniMethod;
import org.fusesource.hawtjni.runtime.Library;
import org.fusesource.hawtjni.runtime.T32;

/**
 * 
 * @author <a href="http://hiramchirino.com">Hiram Chirino</a>
 */
@JniClass
public class Platform {
    
    private static Library library = new Library("hawtjni-example", 1, 0, 0);
	static {
	    library.load();
	}

    public static final void main(String args[]) {
        System.out.println("Allocating memory...");
        long ptr = malloc(1024*4);
        System.out.println(String.format("Allocated at: %x", ptr));
        free(ptr);
        System.out.println("Memory freed.");
    }

	
	@JniMethod(cast="JAVA_PTR_CAST")
    public static final native @T32 long malloc (@T32 long size);
    
    public static final native void free (@JniArg(cast="NATIVE_PTR_CAST") @T32 long ptr);
    
    public static final native @T32 long open (String file, int flags, int mode);
    
    
}
