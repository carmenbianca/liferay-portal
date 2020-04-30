/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.portal.kernel.resiliency.mpi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * @author Shuyang Zhou
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 */
@Deprecated
public interface MPI extends Remote {

	public boolean isAlive() throws RemoteException;

}