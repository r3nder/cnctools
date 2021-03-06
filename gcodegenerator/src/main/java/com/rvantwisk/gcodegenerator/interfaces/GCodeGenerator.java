/*
 * Copyright (c) 2013, R. van Twisk
 * All rights reserved.
 * Licensed under the The BSD 3-Clause License;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 * http://opensource.org/licenses/BSD-3-Clause
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 *
 * Neither the name of the aic-util nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
 * FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 * COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT,
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.rvantwisk.gcodegenerator.interfaces;

import com.rvantwisk.gcodegenerator.GCodeBuilder;
import com.rvantwisk.gcodegenerator.GCodeCollection;

public interface GCodeGenerator {

    /**
     * Add a small comtent on the next line
     *
     * @param comment
     */
    public void comment(final String comment);

    /**
     * Add a large comment on the next line(s)
     *
     * @param comment
     */
    public void commentLarge(final String comment);

    /**
     * Start a new G-Code session
     *
     */
    public void newSet(final boolean mergable, final String id, final String toolId);

    /**
     * Receive a deep copy of the current dataset, this will include the postamble
     *
     * @return
     */
    public GCodeCollection getGCode();

    /**
     * Add a new GCode block
     *
     * @param GCodeBuilder
     */
    public void addBlock(final GCodeBuilder GCodeBuilder);

    /**
     * Add raw gcode, be carefull using raw code, not all dialect's might support what you are trying to accomplish
     *
     * @param s
     */
    void addRaw(String s);

    /**
     * Add the start (preamble) of the GCode to the start of a program
     * Execute this before any G-Code get's added
     */
    void startProgram();

    /**
     * Add the end (postabmle) to the end of the program
     * Execute this after all G-Code has been added, no G-Code can be added after endProgram is called
     */
    void endProgram();

    /**
     * Return the associated post processor configuration
     *
     * @param <T>
     * @return
     */
    public <T extends PostProcessorConfig> T getPostProcessorConfig();


}
