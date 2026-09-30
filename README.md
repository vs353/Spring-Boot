Exception Handling & Validation Flow

POST /employees
      ↓
@RequestBody converts JSON → Employee object
      ↓
@Valid checks Employee
      ↓
@NotBlank / @Positive fails
      ↓
Spring throws MethodArgumentNotValidException
      ↓
@ExceptionHandler catches it
      ↓
getBindingResult()
      ↓
getFieldErrors()
      ↓
extract messages
      ↓
400 BAD REQUEST + error messages
