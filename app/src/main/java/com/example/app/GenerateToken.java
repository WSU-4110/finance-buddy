package com.example.app;
import com.plaid.client.model.*;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import com.plaid.client.request.PlaidApi;

import java.io.IOException;
import java.util.Arrays;

public class GenerateToken {
    private PlaidApi client = new PlaidApi() {
        @Override
        public Call<AccountsGetResponse> accountsBalanceGet(AccountsBalanceGetRequest accountsBalanceGetRequest) {
            return null;
        }

        @Override
        public Call<AccountsGetResponse> accountsGet(AccountsGetRequest accountsGetRequest) {
            return null;
        }

        @Override
        public Call<ApplicationGetResponse> applicationGet(ApplicationGetRequest applicationGetRequest) {
            return null;
        }

        @Override
        public Call<AssetReportAuditCopyCreateResponse> assetReportAuditCopyCreate(AssetReportAuditCopyCreateRequest assetReportAuditCopyCreateRequest) {
            return null;
        }

        @Override
        public Call<AssetReportGetResponse> assetReportAuditCopyGet(AssetReportAuditCopyGetRequest assetReportAuditCopyGetRequest) {
            return null;
        }

        @Override
        public Call<AssetReportAuditCopyRemoveResponse> assetReportAuditCopyRemove(AssetReportAuditCopyRemoveRequest assetReportAuditCopyRemoveRequest) {
            return null;
        }

        @Override
        public Call<AssetReportCreateResponse> assetReportCreate(AssetReportCreateRequest assetReportCreateRequest) {
            return null;
        }

        @Override
        public Call<AssetReportFilterResponse> assetReportFilter(AssetReportFilterRequest assetReportFilterRequest) {
            return null;
        }

        @Override
        public Call<AssetReportGetResponse> assetReportGet(AssetReportGetRequest assetReportGetRequest) {
            return null;
        }

        @Override
        public Call<ResponseBody> assetReportPdfGet(AssetReportPDFGetRequest assetReportPDFGetRequest) {
            return null;
        }

        @Override
        public Call<AssetReportRefreshResponse> assetReportRefresh(AssetReportRefreshRequest assetReportRefreshRequest) {
            return null;
        }

        @Override
        public Call<AssetReportRemoveResponse> assetReportRemove(AssetReportRemoveRequest assetReportRemoveRequest) {
            return null;
        }

        @Override
        public Call<AuthGetResponse> authGet(AuthGetRequest authGetRequest) {
            return null;
        }

        @Override
        public Call<BankTransferBalanceGetResponse> bankTransferBalanceGet(BankTransferBalanceGetRequest bankTransferBalanceGetRequest) {
            return null;
        }

        @Override
        public Call<BankTransferCancelResponse> bankTransferCancel(BankTransferCancelRequest bankTransferCancelRequest) {
            return null;
        }

        @Override
        public Call<BankTransferCreateResponse> bankTransferCreate(BankTransferCreateRequest bankTransferCreateRequest) {
            return null;
        }

        @Override
        public Call<BankTransferEventListResponse> bankTransferEventList(BankTransferEventListRequest bankTransferEventListRequest) {
            return null;
        }

        @Override
        public Call<BankTransferEventSyncResponse> bankTransferEventSync(BankTransferEventSyncRequest bankTransferEventSyncRequest) {
            return null;
        }

        @Override
        public Call<BankTransferGetResponse> bankTransferGet(BankTransferGetRequest bankTransferGetRequest) {
            return null;
        }

        @Override
        public Call<BankTransferListResponse> bankTransferList(BankTransferListRequest bankTransferListRequest) {
            return null;
        }

        @Override
        public Call<BankTransferMigrateAccountResponse> bankTransferMigrateAccount(BankTransferMigrateAccountRequest bankTransferMigrateAccountRequest) {
            return null;
        }

        @Override
        public Call<CategoriesGetResponse> categoriesGet(Object body) {
            return null;
        }

        @Override
        public Call<PaymentInitiationPaymentTokenCreateResponse> createPaymentToken(PaymentInitiationPaymentTokenCreateRequest paymentInitiationPaymentTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<DepositSwitchAltCreateResponse> depositSwitchAltCreate(DepositSwitchAltCreateRequest depositSwitchAltCreateRequest) {
            return null;
        }

        @Override
        public Call<DepositSwitchCreateResponse> depositSwitchCreate(DepositSwitchCreateRequest depositSwitchCreateRequest) {
            return null;
        }

        @Override
        public Call<DepositSwitchGetResponse> depositSwitchGet(DepositSwitchGetRequest depositSwitchGetRequest) {
            return null;
        }

        @Override
        public Call<DepositSwitchTokenCreateResponse> depositSwitchTokenCreate(DepositSwitchTokenCreateRequest depositSwitchTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<EmployersSearchResponse> employersSearch(EmployersSearchRequest employersSearchRequest) {
            return null;
        }

        @Override
        public Call<IdentityGetResponse> identityGet(IdentityGetRequest identityGetRequest) {
            return null;
        }

        @Override
        public Call<IncomeVerificationCreateResponse> incomeVerificationCreate(IncomeVerificationCreateRequest incomeVerificationCreateRequest) {
            return null;
        }

        @Override
        public Call<ResponseBody> incomeVerificationDocumentsDownload(IncomeVerificationDocumentsDownloadRequest incomeVerificationDocumentsDownloadRequest) {
            return null;
        }

        @Override
        public Call<IncomeVerificationPaystubsGetResponse> incomeVerificationPaystubsGet(IncomeVerificationPaystubsGetRequest incomeVerificationPaystubsGetRequest) {
            return null;
        }

        @Override
        public Call<IncomeVerificationRefreshResponse> incomeVerificationRefresh(IncomeVerificationRefreshRequest incomeVerificationRefreshRequest) {
            return null;
        }

        @Override
        public Call<IncomeVerificationSummaryGetResponse> incomeVerificationSummaryGet(IncomeVerificationSummaryGetRequest incomeVerificationSummaryGetRequest) {
            return null;
        }

        @Override
        public Call<InstitutionsGetResponse> institutionsGet(InstitutionsGetRequest institutionsGetRequest) {
            return null;
        }

        @Override
        public Call<InstitutionsGetByIdResponse> institutionsGetById(InstitutionsGetByIdRequest institutionsGetByIdRequest) {
            return null;
        }

        @Override
        public Call<InstitutionsSearchResponse> institutionsSearch(InstitutionsSearchRequest institutionsSearchRequest) {
            return null;
        }

        @Override
        public Call<InvestmentsHoldingsGetResponse> investmentsHoldingsGet(InvestmentsHoldingsGetRequest investmentsHoldingsGetRequest) {
            return null;
        }

        @Override
        public Call<InvestmentsTransactionsGetResponse> investmentsTransactionsGet(InvestmentsTransactionsGetRequest investmentsTransactionsGetRequest) {
            return null;
        }

        @Override
        public Call<ItemAccessTokenInvalidateResponse> itemAccessTokenInvalidate(ItemAccessTokenInvalidateRequest itemAccessTokenInvalidateRequest) {
            return null;
        }

        @Override
        public Call<ItemApplicationListResponse> itemApplicationList(ItemApplicationListRequest itemApplicationListRequest) {
            return null;
        }

        @Override
        public Call<ItemApplicationScopesUpdateResponse> itemApplicationScopesUpdate(ItemApplicationScopesUpdateRequest itemApplicationScopesUpdateRequest) {
            return null;
        }

        @Override
        public Call<ItemPublicTokenCreateResponse> itemCreatePublicToken(ItemPublicTokenCreateRequest itemPublicTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<ItemGetResponse> itemGet(ItemGetRequest itemGetRequest) {
            return null;
        }

        @Override
        public Call<ItemImportResponse> itemImport(ItemImportRequest itemImportRequest) {
            return null;
        }

        @Override
        public Call<ItemPublicTokenExchangeResponse> itemPublicTokenExchange(ItemPublicTokenExchangeRequest itemPublicTokenExchangeRequest) {
            return null;
        }

        @Override
        public Call<ItemRemoveResponse> itemRemove(ItemRemoveRequest itemRemoveRequest) {
            return null;
        }

        @Override
        public Call<ItemWebhookUpdateResponse> itemWebhookUpdate(ItemWebhookUpdateRequest itemWebhookUpdateRequest) {
            return null;
        }

        @Override
        public Call<LiabilitiesGetResponse> liabilitiesGet(LiabilitiesGetRequest liabilitiesGetRequest) {
            return null;
        }

        @Override
        public Call<LinkTokenCreateResponse> linkTokenCreate(LinkTokenCreateRequest linkTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<LinkTokenGetResponse> linkTokenGet(LinkTokenGetRequest linkTokenGetRequest) {
            return null;
        }

        @Override
        public Call<PaymentInitiationPaymentCreateResponse> paymentInitiationPaymentCreate(PaymentInitiationPaymentCreateRequest paymentInitiationPaymentCreateRequest) {
            return null;
        }

        @Override
        public Call<PaymentInitiationPaymentGetResponse> paymentInitiationPaymentGet(PaymentInitiationPaymentGetRequest paymentInitiationPaymentGetRequest) {
            return null;
        }

        @Override
        public Call<PaymentInitiationPaymentListResponse> paymentInitiationPaymentList(PaymentInitiationPaymentListRequest paymentInitiationPaymentListRequest) {
            return null;
        }

        @Override
        public Call<PaymentInitiationRecipientCreateResponse> paymentInitiationRecipientCreate(PaymentInitiationRecipientCreateRequest paymentInitiationRecipientCreateRequest) {
            return null;
        }

        @Override
        public Call<PaymentInitiationRecipientGetResponse> paymentInitiationRecipientGet(PaymentInitiationRecipientGetRequest paymentInitiationRecipientGetRequest) {
            return null;
        }

        @Override
        public Call<PaymentInitiationRecipientListResponse> paymentInitiationRecipientList(PaymentInitiationRecipientListRequest paymentInitiationRecipientListRequest) {
            return null;
        }

        @Override
        public Call<ProcessorTokenCreateResponse> processorApexProcessorTokenCreate(ProcessorApexProcessorTokenCreateRequest processorApexProcessorTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<ProcessorAuthGetResponse> processorAuthGet(ProcessorAuthGetRequest processorAuthGetRequest) {
            return null;
        }

        @Override
        public Call<ProcessorBalanceGetResponse> processorBalanceGet(ProcessorBalanceGetRequest processorBalanceGetRequest) {
            return null;
        }

        @Override
        public Call<ProcessorBankTransferCreateResponse> processorBankTransferCreate(ProcessorBankTransferCreateRequest processorBankTransferCreateRequest) {
            return null;
        }

        @Override
        public Call<ProcessorIdentityGetResponse> processorIdentityGet(ProcessorIdentityGetRequest processorIdentityGetRequest) {
            return null;
        }

        @Override
        public Call<ProcessorStripeBankAccountTokenCreateResponse> processorStripeBankAccountTokenCreate(ProcessorStripeBankAccountTokenCreateRequest processorStripeBankAccountTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<ProcessorTokenCreateResponse> processorTokenCreate(ProcessorTokenCreateRequest processorTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<SandboxBankTransferFireWebhookResponse> sandboxBankTransferFireWebhook(SandboxBankTransferFireWebhookRequest sandboxBankTransferFireWebhookRequest) {
            return null;
        }

        @Override
        public Call<SandboxBankTransferSimulateResponse> sandboxBankTransferSimulate(SandboxBankTransferSimulateRequest sandboxBankTransferSimulateRequest) {
            return null;
        }

        @Override
        public Call<SandboxIncomeFireWebhookResponse> sandboxIncomeFireWebhook(SandboxIncomeFireWebhookRequest sandboxIncomeFireWebhookRequest) {
            return null;
        }

        @Override
        public Call<SandboxItemFireWebhookResponse> sandboxItemFireWebhook(SandboxItemFireWebhookRequest sandboxItemFireWebhookRequest) {
            return null;
        }

        @Override
        public Call<SandboxItemResetLoginResponse> sandboxItemResetLogin(SandboxItemResetLoginRequest sandboxItemResetLoginRequest) {
            return null;
        }

        @Override
        public Call<SandboxItemSetVerificationStatusResponse> sandboxItemSetVerificationStatus(SandboxItemSetVerificationStatusRequest sandboxItemSetVerificationStatusRequest) {
            return null;
        }

        @Override
        public Call<Object> sandboxOauthSelectAccounts(SandboxOauthSelectAccountsRequest sandboxOauthSelectAccountsRequest) {
            return null;
        }

        @Override
        public Call<SandboxProcessorTokenCreateResponse> sandboxProcessorTokenCreate(SandboxProcessorTokenCreateRequest sandboxProcessorTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<SandboxPublicTokenCreateResponse> sandboxPublicTokenCreate(SandboxPublicTokenCreateRequest sandboxPublicTokenCreateRequest) {
            return null;
        }

        @Override
        public Call<SignalDecisionReportResponse> signalDecisionReport(SignalDecisionReportRequest signalDecisionReportRequest) {
            return null;
        }

        @Override
        public Call<SignalEvaluateResponse> signalEvaluate(SignalEvaluateRequest signalEvaluateRequest) {
            return null;
        }

        @Override
        public Call<SignalReturnReportResponse> signalReturnReport(SignalReturnReportRequest signalReturnReportRequest) {
            return null;
        }

        @Override
        public Call<TransactionsGetResponse> transactionsGet(TransactionsGetRequest transactionsGetRequest) {
            return null;
        }

        @Override
        public Call<TransactionsRefreshResponse> transactionsRefresh(TransactionsRefreshRequest transactionsRefreshRequest) {
            return null;
        }

        @Override
        public Call<WebhookVerificationKeyGetResponse> webhookVerificationKeyGet(WebhookVerificationKeyGetRequest webhookVerificationKeyGetRequest) {
            return null;
        }
    };
    String clientUserId = "633f656d3246d000121548ae";



    private PlaidApi getClient(){
        return client;
    }
    public String generate() throws IOException {
        LinkTokenCreateRequestUser user = new LinkTokenCreateRequestUser()
                .clientUserId(clientUserId)
                .legalName("legal name")
                .phoneNumber("4155558888")
                .emailAddress("email@address.com");

        LinkTokenCreateRequest request = new LinkTokenCreateRequest()
                .user(user)
                .clientName("Plaid Test App")
                .products(Arrays.asList(Products.AUTH))
                .countryCodes(Arrays.asList(CountryCode.US))
                .language("en")
                .webhook("https://example.com/webhook")
                .linkCustomizationName("default")
                .androidPackageName("com.example.app");

        Response<LinkTokenCreateResponse> response = getClient()
                .linkTokenCreate(request)
                .execute();

        String linkToken = response.body().getLinkToken();
        return linkToken;
    }


}
