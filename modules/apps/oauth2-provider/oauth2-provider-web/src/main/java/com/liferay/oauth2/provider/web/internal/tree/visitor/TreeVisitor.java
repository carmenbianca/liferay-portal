/*
 * SPDX-FileCopyrightText: © 2020 Liferay, Inc. <https://liferay.com>
 * SPDX-License-Identifier: LGPL-2.1-or-later
 */

package com.liferay.oauth2.provider.web.internal.tree.visitor;

import com.liferay.oauth2.provider.web.internal.tree.Tree;

/**
 * @author Carlos Sierra Andrés
 */
public interface TreeVisitor<T, R> {

	public R visitLeaf(Tree.Leaf<T> leaf);

	public R visitNode(Tree.Node<T> node);

}