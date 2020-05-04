/*
 * SPDX-FileCopyrightText: © 2018 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.dynamic.data.mapping.expression;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author Leonardo Barros
 */
public final class ExecuteActionResponse {

	public <T> Optional<T> getOutputOptional(String name) {
		if (!_output.containsKey(name)) {
			return Optional.empty();
		}

		return Optional.of((T)_output.get(name));
	}

	public static class Builder {

		public static Builder newBuilder(boolean success) {
			return new Builder(success);
		}

		public ExecuteActionResponse build() {
			return _executeActionResponse;
		}

		public Builder withOutput(String name, Object value) {
			_executeActionResponse._output.put(name, value);

			return this;
		}

		private Builder(boolean success) {
			_executeActionResponse._success = success;
		}

		private final ExecuteActionResponse _executeActionResponse =
			new ExecuteActionResponse();

	}

	private ExecuteActionResponse() {
	}

	private Map<String, Object> _output = new HashMap<>();
	private boolean _success;

}