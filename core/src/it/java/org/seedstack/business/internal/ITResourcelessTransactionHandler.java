/**
 * Copyright (c) 2013-2015 by The SeedStack authors. All rights reserved.
 *
 * This file is part of SeedStack, An enterprise-oriented full development stack.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package org.seedstack.business.internal;


import org.seedstack.seed.it.api.ITBind;
import org.seedstack.seed.transaction.spi.TransactionHandler;
import org.seedstack.seed.transaction.spi.TransactionMetadata;

@ITBind
public class ITResourcelessTransactionHandler implements TransactionHandler<Object> {

	@Override
	public void doInitialize(TransactionMetadata transactionMetadata) {
	}

	@Override
	public Object doCreateTransaction() {
		return new Object();
	}

	@Override
	public void doBeginTransaction(Object currentTransaction) {
	}

	@Override
	public void doCommitTransaction(Object currentTransaction) {
	}

	@Override
	public void doRollbackTransaction(Object currentTransaction) {
	}

	@Override
	public void doReleaseTransaction(Object currentTransaction) {
	}

	@Override
	public void doCleanup() {
	}

	@Override
	public Object getCurrentTransaction() {
		return new Object();
	}

    @Override
    public void doJoinGlobalTransaction() {

    }

    @Override
    public void doMarkTransactionAsRollbackOnly(Object currentTransaction) {

    }
}