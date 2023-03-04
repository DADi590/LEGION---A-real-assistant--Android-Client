/*
 * Copyright 2023 DADi590
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

package com.dadi590.assist_c_a.GlobalUtils;

import android.Manifest;
import android.media.AudioFormat;
import android.media.AudioRecord;

public final class UtilsAudio {
	/**
	 * <p>Checks if a {@link android.media.MediaRecorder.AudioSource} is available for immediate use.</p>
	 *
	 * @param audio_source the audio source to check
	 *
	 * @return true if it's available for immediate use, false otherwise (doesn't exist on the device or is busy) OR if
	 * there is no permission to record audio (check that before calling this function)
	 */
	public static boolean isAudioSourceAvailable(final int audio_source) {
		final int sample_rate = 44100;
		final int channel_config = AudioFormat.CHANNEL_IN_MONO;
		final int audio_format = AudioFormat.ENCODING_PCM_16BIT;

		if (!UtilsPermsAuths.checkSelfPermission(Manifest.permission.RECORD_AUDIO)) {
			return false;
		}

		final AudioRecord audioRecord;
		try {
			audioRecord = new AudioRecord(audio_source, sample_rate, channel_config, audio_format,
					AudioRecord.getMinBufferSize(sample_rate, channel_config, audio_format));
		} catch (final IllegalStateException ignored) {
			return false;
		}

		final boolean initialized = AudioRecord.STATE_INITIALIZED == audioRecord.getState();

		boolean success_recording = false;
		if (initialized) {
			try {
				audioRecord.startRecording();
				success_recording = audioRecord.getRecordingState() == AudioRecord.RECORDSTATE_RECORDING;
			} catch (final IllegalStateException ignored) {
			}
		}

		if (initialized) {
			// If it's initialized, stop it.
			audioRecord.stop();
		}
		audioRecord.release();

		return success_recording;
	}
}