/*
 * SPDX-FileCopyrightText: © 2019 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.exportimport.kernel.lifecycle;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Daniel Kocsis
 */
@ProviderType
public interface ExportImportLifecycleEvent extends Serializable {

	public List<Serializable> getAttributes();

	public int getCode();

	public int getProcessFlag();

	public String getProcessId();

	public void setAttributes(Serializable... attributes);

	public void setCode(int eventCode);

	public void setProcessFlag(int processFlag);

	public void setProcessId(String processId);

}