/*
 * Copyright (c) 2020 Plaid Technologies, Inc. <support@plaid.com>
 */

package com.example.app;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;

import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.plaid.link.OpenPlaidLink;
import com.plaid.link.Plaid;
import com.plaid.link.configuration.LinkTokenConfiguration;
import com.plaid.link.result.LinkExit;
import com.plaid.link.result.LinkSuccess;


import com.plaid.linksample.network.LinkTokenRequester;
import kotlin.Unit;


public class MainActivityJava extends AppCompatActivity implements View.OnClickListener{

  private TextView result;
  private TextView tokenResult;
  private TextView link;


  private ActivityResultLauncher<LinkTokenConfiguration> linkAccountToPlaid = registerForActivityResult(
      new OpenPlaidLink(),
      result -> {
        if (result instanceof LinkSuccess) {
          showSuccess((LinkSuccess) result);
        } else {
          showFailure((LinkExit) result);
        }
      });

  private void showSuccess(LinkSuccess success) {
    tokenResult.setText(getString(R.string.public_token_result, success.getPublicToken()));
    result.setText(getString(R.string.content_success));

    Log.e("Public token",tokenResult.getText().toString());

  }

  private void showFailure(LinkExit exit) {
    tokenResult.setText("");
    if (exit.getError() != null) {
      result.setText(getString(
          R.string.content_exit,
          exit.getError().getDisplayMessage(),
          exit.getError().getErrorCode()));
    } else {
      result.setText(getString(
          R.string.content_cancel,
          exit.getMetadata().getStatus() != null ? exit.getMetadata().getStatus().getJsonValue() : "unknown"));
    }
  }



  @Override
  protected void onCreate(Bundle savedInstanceState) {
    try{
      super.onCreate(savedInstanceState);
      setContentView(R.layout.newone);
    }catch(Exception e){
      Log.e( "onCreateView", e.getMessage());
    }

    result = findViewById(R.id.result);
    tokenResult = findViewById(R.id.public_token_result);

    link = findViewById(R.id.open_link);
    link.setOnClickListener(this);


  }

  /**
   * Optional, set an <a href="https://plaid.com/docs/link/android/#handling-onevent">event listener</a>.
   */
  private void setOptionalEventListener() {
    Plaid.setLinkEventListener(linkEvent -> {
      Log.i("Event", linkEvent.toString());
      return Unit.INSTANCE;
    });
  }

  /**
   * For all Link configuration options, have a look at the
   * <a href="https://plaid.com/docs/link/android/#parameter-reference">parameter reference</>
   */
  private void openLink() {

    Log.e("tag","openlink called");
    LinkTokenRequester.INSTANCE.getToken()
        .subscribe(this::onLinkTokenSuccess, this::onLinkTokenError);

  }

  private void onLinkTokenSuccess(String token) {
    LinkTokenConfiguration configuration = new LinkTokenConfiguration.Builder()
        .token(token)
        .build();
    linkAccountToPlaid.launch(configuration);
  }

  private void onLinkTokenError(Throwable error) {
    if (error instanceof java.net.ConnectException) {
      Toast.makeText(
          this,
          "Please run `sh start_server.sh <client_id> <sandbox_secret>`",
          Toast.LENGTH_LONG).show();
      return;
    }
    Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();

    inflater.inflate(R.menu.menu_java, menu);

    return true;
  }

  @SuppressWarnings("SwitchStatementWithTooFewBranches")
  @Override
  public boolean onOptionsItemSelected(@NonNull MenuItem item) {
    switch (item.getItemId()) {
      case R.id.show_kotlin:
        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
        return true;
      default:
        return super.onOptionsItemSelected(item);
    }
  }

  @Override
  public void onClick(View view) {

      setOptionalEventListener();
      openLink();

  }
}
