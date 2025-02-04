/*
 * Copyright 2021-2024 Edw590
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.edw590.visor_c_a.Modules.SpeechRecognitionCtrl;

/**
 * <p>Constants directly related to the Speech Recognition module.</p>
 */
public final class CONSTS_SpeechRecog {

	/** Use this to start the services in this package and put on it the result of {@link System#currentTimeMillis()}
	 * at the moment of calling with as little delay as possible. */
	static final String EXTRA_TIME_START = "EXTRA_TIME_START";
	/** Use this to enable or disable partial recognition results. If not used, partial results will not be used. */
	static final String EXTRA_PARTIAL_RESULTS = "EXTRA_PARTIAL_RESULTS";

	/**
	 * <p>Private empty constructor so the class can't be instantiated (utility class).</p>
	 */
	private CONSTS_SpeechRecog() {
	}
}
