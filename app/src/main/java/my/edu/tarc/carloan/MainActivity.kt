package my.edu.tarc.carloan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    //onCreate = main() fun
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        //Create UI, loaded into layout folder with the file activity main
        setContentView(R.layout.activity_main)

        //Link UI to code
        val editTextCarPrice: EditText = findViewById(R.id.editTextCarPrice)
        val editTextDownPayment = findViewById<EditText>(R.id.editDownPayment)
        val editTextLoanPeriod: EditText = findViewById(R.id.editLoanPeriod)
        val editTextInterestRate: EditText = findViewById(R.id.editInterestRate)
        val textViewMonthlyPayment: TextView = findViewById(R.id.textViewMonthlyPayment)

        val buttonReset: Button = findViewById(R.id.buttonReset)
        val buttonCalculate: Button = findViewById(R.id.buttonCalculate)

        buttonReset.setOnClickListener{
            //TODO: Write event handler for button reset
            editTextCarPrice.text.clear()
            editTextDownPayment.text.clear()
            editTextLoanPeriod.text.clear()
            editTextInterestRate.text.clear()
        }
        buttonCalculate.setOnClickListener{
            //TODO: Write even handler for buttoncalc

            var carPrice = editTextCarPrice.text.toString().toInt()
            var downPayment = editTextDownPayment.text.toString().toInt()
            var loanPeriod = editTextLoanPeriod.text.toString().toShort()
            var interestRate = editTextInterestRate.text.toString().toFloat()

//            if (carPrice == null) { //method 1
//                editTextCarPrice.setError(getString(R.string.value_required))
//                return@setOnClickListener //terminate this function
//            }
            if(editTextCarPrice.text.isEmpty()){ //method 2
                editTextCarPrice.setError(getString(R.string.value_required))
                return@setOnClickListener
            }
            if(editTextDownPayment.text.isEmpty()){ //method 2
                editTextDownPayment.setError(getString(R.string.value_required))
                return@setOnClickListener
            }
            if(editTextLoanPeriod.text.isEmpty()){ //method 2
                editTextLoanPeriod.setError(getString(R.string.value_required))
                return@setOnClickListener
            }
            if(editTextInterestRate.text.isEmpty()){ //method 2
                editTextInterestRate.setError(getString(R.string.value_required))
                return@setOnClickListener
            }


            interestRate /= 100
            val carLoan: Float = (carPrice - downPayment).toFloat()
            val interest: Float = (carLoan * interestRate * loanPeriod).toFloat()
            val monthlyPayment: Float = ((carLoan + interest) / loanPeriod / 12)
            textViewMonthlyPayment.text = String.format("%.2f", monthlyPayment)
990
        }
    }
}